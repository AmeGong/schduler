package com.example.domain.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.types.enums.TaskType;

public class TaskProcessorFactory {
    
    private static Map<String, TaskProcessor> taskProcessors = new ConcurrentHashMap<>();

    public static synchronized void registry(TaskProcessor taskProcessor) {
        TaskType taskType = taskProcessor.supportTaskType();
        if (taskProcessors.containsKey(taskType.name())) {
            throw new RuntimeException("Failed to registry the same TaskHandler");
        }

        taskProcessors.put(taskType.name(), taskProcessor);
    }

    public static TaskProcessor get(TaskType taskType) {
        TaskProcessor taskProcessor = taskProcessors.get(taskType.name());
        if (taskProcessor == null) {
            throw new RuntimeException(String.format("Cannot find the TaskProcessor of the %s TaskType", taskType.name()));
        }
        return taskProcessor;
    }
}
