package com.example.domain.entity;

import java.util.Date;

import com.example.types.RecordId;
import com.example.types.enums.TaskStatus;
import com.example.types.enums.TaskType;

public class TaskRecord implements BaseEntity<RecordId> {
    
    private RecordId recordId;

    private TaskType taskType;

    private TaskStatus taskStatus;

    private String taskContext;

    private Integer extTimes;

    private Date gmtCreated;

    private Date gmtModified;

    private Date nextExeTime;

    public RecordId getRecordId() {
        return recordId;
    }

    public void setRecordId(RecordId recordId) {
        this.recordId = recordId;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskContext() {
        return taskContext;
    }

    public void setTaskContext(String taskContext) {
        this.taskContext = taskContext;
    }

    public Integer getExtTimes() {
        return extTimes;
    }

    public void setExtTimes(Integer extTimes) {
        this.extTimes = extTimes;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getNextExeTime() {
        return nextExeTime;
    }

    public void setNextExeTime(Date nextExeTime) {
        this.nextExeTime = nextExeTime;
    }

    


}
