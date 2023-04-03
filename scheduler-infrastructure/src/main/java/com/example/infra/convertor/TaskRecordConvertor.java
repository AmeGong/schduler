package com.example.infra.convertor;

import java.util.List;


import com.example.types.RecordId;
import com.example.types.enums.TaskStatus;
import com.example.types.enums.TaskType;
import org.springframework.beans.BeanUtils;

import com.example.domain.entity.TaskRecord;
import com.example.infra.po.TaskRecordDO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TaskRecordConvertor {
    
    public static TaskRecordDO convertToDO(@NotNull TaskRecord taskRecord) {
        TaskRecordDO taskRecordDO = new TaskRecordDO();
        BeanUtils.copyProperties(taskRecord, taskRecordDO);
        taskRecordDO.setRecordId(Integer.valueOf(taskRecord.getRecordId().getId()));
        taskRecordDO.setTaskType(taskRecord.getTaskType().name());
        taskRecordDO.setTaskStatus(taskRecord.getTaskStatus().name());
        return taskRecordDO;
    }

    public static TaskRecord convertFromDO(@NotNull TaskRecordDO taskRecordDO) {
        TaskRecord taskRecord = new TaskRecord();
        BeanUtils.copyProperties(taskRecordDO,taskRecord);
        taskRecord.setRecordId(new RecordId(taskRecordDO.getRecordId()));
        taskRecord.setTaskType(TaskType.getByCode(taskRecordDO.getTaskType()));
        taskRecord.setTaskStatus(TaskStatus.getByCode(taskRecordDO.getTaskStatus()));
        return taskRecord;
    }

    public static List<TaskRecord> convertFromDO(@NotEmpty List<TaskRecordDO> taskRecordDOList) {
        // TODO
        return null;
    }


}
