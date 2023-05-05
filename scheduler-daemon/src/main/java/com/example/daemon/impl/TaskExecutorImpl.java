package com.example.daemon.impl;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import com.example.types.exception.SchedulerRetryableException;
import com.example.types.exception.SchedulerUnretryableException;
import com.google.common.util.concurrent.RateLimiter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;

import com.example.daemon.TaskExecutor;
import com.example.daemon.ThreadPoolManage;
import com.example.domain.entity.TaskRecord;
import com.example.infra.repository.TaskRecordRepository;
import com.example.types.EntityId;
import com.example.types.enums.TaskStatus;

@Component
public class TaskExecutorImpl implements TaskExecutor {

    protected static Log LOG = LogFactory.getLog(TaskExecutorImpl.class);

    private RateLimiter rateLimiter = RateLimiter.create(100);

    @Autowired
    private TaskRecordRepository taskRecordRepository;

    @Autowired
    private ThreadPoolManage threadPoolManage;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void execute(List<EntityId> entityIdList) {
        if (CollectionUtils.isEmpty(entityIdList)) {
            return;
        }
        ThreadPoolExecutor executorPool = threadPoolManage.getExecutorPool();
        for (EntityId entityId : entityIdList) {
            executorPool.execute(new Runnable() {
                @Override
                public void run() {
                    doExecute(entityId);
                }
            });

        }
    }

    private void doExecute(EntityId entityId) {
        TaskRecord taskRecord = taskRecordRepository.find(entityId);
        if (taskRecord == null)
            return;
        if (!rateLimiter.tryAcquire()){
            return;
        }
        try {
            if (taskRecord.schedulable()) {
                if (!taskRecordRepository.optimisticLockByStatus(taskRecord.getRecordId(), taskRecord.getTaskStatus(),
                        TaskStatus.PROCESSING)) {
                    return;
                }
                taskRecord.setTaskStatus(TaskStatus.PROCESSING);
                boolean success = taskRecord.execute();
                if (success) {
                    taskRecord.setTaskStatus(TaskStatus.COMPLETED);
                } else {
                    taskRecord.setTaskStatus(TaskStatus.ERROR);
                }
            }
        } catch (SchedulerRetryableException rle) {
            taskRecord.adjustNextExeTime();
            taskRecord.setTaskStatus(TaskStatus.WAITING);
            LOG.error(rle);
        } catch (SchedulerUnretryableException urle) {
            taskRecord.setTaskStatus(TaskStatus.ERROR);
            LOG.error(urle);
        } catch (Throwable t) {
            taskRecord.adjustNextExeTime();
            taskRecord.setTaskStatus(TaskStatus.WAITING);
            LOG.error(t);
        } finally {
            // consider save fail
            taskRecordRepository.save(taskRecord);
        }
    }

}
