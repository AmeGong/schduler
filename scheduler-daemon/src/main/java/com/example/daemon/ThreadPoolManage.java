package com.example.daemon;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

public class ThreadPoolManage {
    

    private ThreadPoolExecutor executorPool;

    private ThreadPoolExecutor splitPool;

    public ThreadPoolExecutor getExecutorPool() {
        return executorPool;
    }

    public void setExecutorPool(ThreadPoolExecutor executorPool) {
        this.executorPool = executorPool;
    }

    public ThreadPoolExecutor getSplitPool() {
        return splitPool;
    }

    public void setSplitPool(ThreadPoolExecutor splitPool) {
        this.splitPool = splitPool;
    }


}
