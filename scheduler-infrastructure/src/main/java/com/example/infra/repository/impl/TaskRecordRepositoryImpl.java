package com.example.infra.repository.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import com.example.domain.entity.TaskRecord;
import com.example.infra.convertor.TaskRecordConvertor;
import com.example.infra.dao.auto.TaskRecordMapper;
import com.example.infra.dao.manual.TaskRecordManualMapper;
import com.example.infra.po.TaskRecordDO;
import com.example.infra.po.TaskRecordDOExample;
import com.example.infra.repository.TaskRecordRepository;
import com.example.types.EntityId;
import com.example.types.enums.TaskStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

@Repository
public class TaskRecordRepositoryImpl implements TaskRecordRepository {

    @Autowired
    private TaskRecordMapper taskRecordMapper;

    @Autowired
    private TaskRecordManualMapper taskRecordManualMapper;

    @Override
    public List<TaskRecord> find(TaskRecord entity) {
        throw new RuntimeException("This method hasn't been implemented!");
    }

    @Override
    public TaskRecord find(EntityId entityId) {
        validate(entityId);
        TaskRecordDOExample example = new TaskRecordDOExample();
        example.createCriteria().andRecordIdEqualTo(Integer.valueOf(entityId.getId()));
        List<TaskRecordDO> result = taskRecordMapper.selectByExample(example);
        return CollectionUtils.isEmpty(result) ? null : TaskRecordConvertor.convertFromDO(result.get(0));
    }

    @Override
    public int save(TaskRecord entity) {
        validate(entity);
        if (entity.getRecordId() != null) {
            // The record does exist, update it
            TaskRecordDOExample example = new TaskRecordDOExample();
            example.createCriteria().andRecordIdEqualTo(Integer.valueOf(entity.getRecordId().getId()));
            return taskRecordMapper.updateByExampleSelective(TaskRecordConvertor.convertToDO(entity), example);

        } else {
            // The record doesn't exist, insert it
            return taskRecordMapper.insertSelective(TaskRecordConvertor.convertToDO(entity));
        }
    }

    @Override
    public int delete(EntityId entityId) {
        validate(entityId);
        TaskRecordDOExample example = new TaskRecordDOExample();
        example.createCriteria().andRecordIdEqualTo(Integer.valueOf(entityId.getId()));
        return taskRecordMapper.deleteByExample(example);
    }

    @Override
    public List<Integer> find(Set<TaskStatus> statusSet, Date exeTime) {
        validate(statusSet);
        validate(exeTime);
        List<String> statusList = statusSet.stream().map(TaskStatus::name).collect(Collectors.toList());
        return taskRecordManualMapper.selectRecordId(statusList, exeTime);
    }

    @Override
    public TaskRecord lock(EntityId entityId) {
        return TaskRecordConvertor.convertFromDO(taskRecordManualMapper.lock(Integer.valueOf(entityId.getId())));
    }

    public TaskRecordMapper getTaskRecordMapper() {
        return taskRecordMapper;
    }

    public void setTaskRecordMapper(TaskRecordMapper taskRecordMapper) {
        this.taskRecordMapper = taskRecordMapper;
    }

    public TaskRecordManualMapper getTaskRecordManualMapper() {
        return taskRecordManualMapper;
    }

    public void setTaskRecordManualMapper(TaskRecordManualMapper taskRecordManualMapper) {
        this.taskRecordManualMapper = taskRecordManualMapper;
    }

}
