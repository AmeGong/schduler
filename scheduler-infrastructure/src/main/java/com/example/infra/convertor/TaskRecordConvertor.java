package com.example.infra.convertor;

import java.util.List;


import org.springframework.beans.BeanUtils;

import com.example.domain.entity.TaskRecord;
import com.example.infra.po.TaskRecordDO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TaskRecordConvertor {
    
    public static TaskRecordDO convertToDO(@NotNull TaskRecord taskRecord) {
        TaskRecordDO taskRecordDO = new TaskRecordDO();
        BeanUtils.copyProperties(taskRecord, taskRecordDO);
        taskRecordDO.setTaskType(taskRecord.getTaskType().name());
        taskRecordDO.setTaskStatus(taskRecord.getTaskStatus().name());
        return taskRecordDO;
    }

    public static TaskRecord convertFromDO(@NotNull TaskRecordDO taskRecordDO) {
        // TODO
        return null;
    }

    public static List<TaskRecord> convertFromDO(@NotEmpty List<TaskRecordDO> taskRecordDOList) {
        // TODO
        return null;
    }


}
