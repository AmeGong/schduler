package com.example.daemon.impl;

import java.util.*;

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

    private final static int SUB_LIST_SIZE = 100;

    @Autowired
    private TaskRecordRepository taskRecordRepository;

    @Autowired
    private TaskExecutor taskExecutor;

    @Override
    public void split(Date exeTime) {
        List<EntityId> entityIds = taskRecordRepository.find(TaskRecord.EXECUTABLE_STATUS, exeTime);
        if (!CollectionUtils.isEmpty(entityIds))  {
            List<List<EntityId>> entitySubLists = shuffleBatch(entityIds, SUB_LIST_SIZE);
            for (List<EntityId> subList : entitySubLists) {
                taskExecutor.execute(subList);
            }
        }
    }

    private List<List<EntityId>> shuffleBatch(List<EntityId> list, int subListSize) {
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
