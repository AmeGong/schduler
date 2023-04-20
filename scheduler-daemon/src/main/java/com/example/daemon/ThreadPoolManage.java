package com.example.daemon;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolManage {
    

    private ThreadPoolExecutor executorPool = new ThreadPoolExecutor(5,100,0, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

    private ThreadPoolExecutor backgroudPool = new ThreadPoolExecutor(1,5,0, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

    public ThreadPoolExecutor getExecutorPool() {
        return executorPool;
    }

    public void setExecutorPool(ThreadPoolExecutor executorPool) {
        this.executorPool = executorPool;
    }

    public ThreadPoolExecutor getBackgroudPool() {
        return backgroudPool;
    }

    public void setBackgroudPool(ThreadPoolExecutor backgroudPool) {
        this.backgroudPool = backgroudPool;
    }

    
}
