package com.example.daemon.impl;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

import com.example.daemon.ThreadPoolManage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.daemon.TaskExecutor;
import com.example.daemon.TaskSplitor;
import com.example.domain.entity.TaskRecord;
import com.example.infra.repository.TaskRecordRepository;
import com.example.types.EntityId;

@Component
public class TaskSplitorImpl implements TaskSplitor {

    protected static Log LOG = LogFactory.getLog(TaskExecutorImpl.class);

    private final static int SUB_LIST_SIZE = 100;

    @Autowired
    private TaskRecordRepository taskRecordRepository;

    @Autowired
    private TaskExecutor taskExecutor;

    @Override
    public void split(Date exeTime) {
        LOG.info("start to split task!");
        List<EntityId> entityIds = taskRecordRepository.find(TaskRecord.EXECUTABLE_STATUS, exeTime);
        if (!CollectionUtils.isEmpty(entityIds))  {
            List<List<EntityId>> entitySubLists = batchShuffle(entityIds, SUB_LIST_SIZE);
            for (List<EntityId> subList : entitySubLists) {
                taskExecutor.execute(subList);
            }
        }
    }

    private List<List<EntityId>> batchShuffle(List<EntityId> list, int subListSize) {
        List<List<EntityId>> result = new ArrayList<>();
        int total = list.size();
        int loop = total / subListSize;
        if (loop == 0) {
            Collections.shuffle(list);
            result.add(list);
        } else {
            for (int i = 0; i < loop; i++) {
                List<EntityId> subList = list.subList(i*subListSize, Math.min((i + 1) * subListSize, total));
                Collections.shuffle(subList);
                result.add(subList);
            }
        }
        Collections.shuffle(result);
        return result;
    }
}
