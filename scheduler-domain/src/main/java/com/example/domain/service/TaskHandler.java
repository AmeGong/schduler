package com.example.domain.service;

import com.example.domain.entity.TaskRecord;
import com.example.types.enums.TaskType;

public interface TaskHandler {

    TaskType supportTaskType();

    boolean handle(TaskRecord taskRecord);
    
}
