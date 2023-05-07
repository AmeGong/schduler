package com.example.daemon;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Scheduler implements InitializingBean {

    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

    @Autowired
    private TaskSplitor taskSplitor;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run() {
                taskSplitor.split(new Date());
            }

        }, 3,3, TimeUnit.SECONDS);
    }

}
