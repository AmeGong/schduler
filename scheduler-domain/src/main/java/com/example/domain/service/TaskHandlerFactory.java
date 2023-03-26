package com.example.domain.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.types.enums.TaskType;

public class TaskHandlerFactory {
    
    private static Map<String, TaskHandler> taskHandlers = new ConcurrentHashMap<>();

    public static synchronized void registry(TaskHandler taskHandler) {
        TaskType taskType = taskHandler.supportTaskType();
        if (taskHandlers.containsKey(taskType.name())) {
            throw new RuntimeException("Failed to registry the same TaskHandler");
        }

        taskHandlers.put(taskType.name(), taskHandler);
    }

    public static TaskHandler get(TaskType taskType) {
        TaskHandler taskHandler = taskHandlers.get(taskType.name());
        if (taskHandler == null) {
            throw new RuntimeException(String.format("Cannot find the TaskHandler of the %s TaskType", taskType.name()));
        }
        return taskHandler;
    }
}
