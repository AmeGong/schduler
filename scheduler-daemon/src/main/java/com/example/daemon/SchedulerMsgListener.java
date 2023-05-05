package com.example.daemon;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
//@KafkaListener(topics = "schedule", groupId = "test")
public class SchedulerMsgListener {

//    @Autowired
    private TaskSplitor taskSplitor;

//    @KafkaHandler
    public void handleSchedule(Date exeTime) {
        taskSplitor.split(exeTime);
    }

    public TaskSplitor getTaskSplitor() {
        return taskSplitor;
    }

    public void setTaskSplitor(TaskSplitor taskSplitor) {
        this.taskSplitor = taskSplitor;
    }
}
