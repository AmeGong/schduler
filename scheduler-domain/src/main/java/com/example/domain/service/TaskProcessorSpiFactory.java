package com.example.domain.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.types.enums.TaskType;

public class TaskProcessorSpiFactory {
    
    private static Map<String, TaskProcessorSpi> taskProcessors = new ConcurrentHashMap<>();

    public static synchronized void registry(TaskProcessorSpi taskProcessor) {
        TaskType taskType = taskProcessor.supportTaskType();
        if (taskProcessors.containsKey(taskType.name())) {
            throw new RuntimeException("Failed to registry the same TaskHandler");
        }

        taskProcessors.put(taskType.name(), taskProcessor);
    }

    public static TaskProcessorSpi get(TaskType taskType) {
        TaskProcessorSpi taskProcessor = taskProcessors.get(taskType.name());
        if (taskProcessor == null) {
            throw new RuntimeException(String.format("Cannot find the TaskProcessor of the %s TaskType", taskType.name()));
        }
        return taskProcessor;
    }
}
