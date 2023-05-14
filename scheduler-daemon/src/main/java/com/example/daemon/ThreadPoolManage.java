package com.example.daemon;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class ThreadPoolManage {

    private static ThreadPoolExecutor executorPool = new ThreadPoolExecutor(5,100,0, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactoryBuilder().setNameFormat("Task-Executor-Pool").build());

    private static ThreadPoolExecutor backgroundPool = new ThreadPoolExecutor(1,100,0, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),new ThreadFactoryBuilder().setNameFormat("Background-Executor-Pool").build());

    public static ThreadPoolExecutor getExecutorPool() {
        return executorPool;
    }

    public static ThreadPoolExecutor getBackgroundPool() {
        return backgroundPool;
    }
    
}
