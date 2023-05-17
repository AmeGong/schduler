package com.example.domain.service;

import com.example.domain.entity.TaskRecord;
import com.example.types.enums.TaskType;

public interface TaskProcessorSpi {

    TaskType supportTaskType();

    /**
     * this method should be idempotent
     * @param taskRecord
     * @return
     */
    boolean process(TaskRecord taskRecord);
    
}
