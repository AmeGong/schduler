package com.example.infra.convertor;

import java.util.List;


import com.example.types.RecordId;
import com.example.types.enums.TaskStatus;
import com.example.types.enums.TaskType;
import org.springframework.beans.BeanUtils;

import com.example.domain.entity.TaskRecord;
import com.example.infra.po.TaskRecordDO;

public class TaskRecordConvertor {
    
    public static TaskRecordDO convertToDO(TaskRecord taskRecord) {
        if (taskRecord == null) {
            return null;
        }
        TaskRecordDO taskRecordDO = new TaskRecordDO();
        BeanUtils.copyProperties(taskRecord, taskRecordDO);
        if (taskRecord.getRecordId() != null) {
            taskRecordDO.setRecordId(Integer.valueOf(taskRecord.getRecordId().getId()));
        }
        taskRecordDO.setTaskType(taskRecord.getTaskType().name());
        taskRecordDO.setTaskStatus(taskRecord.getTaskStatus().name());
        return taskRecordDO;
    }

    public static TaskRecord convertFromDO(TaskRecordDO taskRecordDO) {
        if (taskRecordDO == null) return null;
        TaskRecord taskRecord = new TaskRecord();
        BeanUtils.copyProperties(taskRecordDO,taskRecord);
        taskRecord.setRecordId(new RecordId(taskRecordDO.getRecordId()));
        taskRecord.setTaskType(TaskType.getByCode(taskRecordDO.getTaskType()));
        taskRecord.setTaskStatus(TaskStatus.getByCode(taskRecordDO.getTaskStatus()));
        return taskRecord;
    }

    public static List<TaskRecord> convertFromDO(List<TaskRecordDO> taskRecordDOList) {
        // TODO
        return null;
    }


}
