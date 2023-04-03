package com.example.domain.service;

import com.example.domain.entity.TaskRecord;
import com.example.types.enums.TaskType;

public interface TaskProcessorSpi {

    TaskType supportTaskType();

    boolean process(TaskRecord taskRecord);
    
}
