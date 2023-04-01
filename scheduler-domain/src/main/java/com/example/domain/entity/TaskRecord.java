package com.example.domain.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.domain.service.TaskProcessor;
import com.example.domain.service.TaskProcessorFactory;
import com.example.types.RecordId;
import com.example.types.enums.TaskStatus;
import com.example.types.enums.TaskType;

import javax.validation.constraints.NotNull;

public class TaskRecord implements BaseEntity<RecordId> {
    
    protected static final Log LOG = LogFactory.getLog(TaskRecord.class);

    private static final int EXECUTE_INTERVAL = 10000;

    public static final Set<TaskStatus> EXECUTABLE_STATUS = new HashSet<>();

    static {
        EXECUTABLE_STATUS.add(TaskStatus.INITIAL);
        EXECUTABLE_STATUS.add(TaskStatus.WAITING);
    }
    
    @NotNull
    private RecordId recordId;

    @NotNull
    private TaskType taskType;

    @NotNull
    private TaskStatus taskStatus;

    /**
     * The business context of the task record
     */
    private String taskContext;

    /**
     * The times of the task has been executed
     */
    @NotNull
    private Integer exeTimes;

    @NotNull
    private Date gmtCreated;

    @NotNull
    private Date gmtModified;

    /**
     * When the task will be executed next time;
     */
    @NotNull
    private Date nextExeTime;

    public boolean schedulable() {
        return (taskStatus == TaskStatus.INITIAL || taskStatus == TaskStatus.WAITING) &&
                (exeTimes <= taskType.getMaxRetryTimes());
    }

    public boolean execute() {
        TaskProcessor taskProcessor = TaskProcessorFactory.get(taskType);
        exeTimes++;
        return taskProcessor.process(this);
    }

    public void adjustNextExeTime() {
        this.nextExeTime.setTime(this.nextExeTime.getTime() + EXECUTE_INTERVAL);
    }

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

    public Integer getExeTimes() {
        return exeTimes;
    }

    public void setExeTimes(Integer exeTimes) {
        this.exeTimes = exeTimes;
    }

    


}
