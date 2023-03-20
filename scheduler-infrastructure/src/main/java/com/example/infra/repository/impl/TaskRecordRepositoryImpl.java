package com.example.infra.repository.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.domain.entity.TaskRecord;
import com.example.infra.convertor.TaskRecordConvertor;
import com.example.infra.dao.auto.TaskRecordMapper;
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

    @Override
    public List<TaskRecord> find(TaskRecord entity) {
        throw new RuntimeException("This method hasn't been implemented!");
    }

    @Override
    public TaskRecord find(EntityId entityId) {
        TaskRecordDOExample example = new TaskRecordDOExample();
        example.createCriteria().andRecordIdEqualTo(Integer.valueOf(entityId.getId()));
        List<TaskRecordDO> result = taskRecordMapper.selectByExample(example);
        return CollectionUtils.isEmpty(result) ? null : TaskRecordConvertor.convertFromDO(result.get(0));
    }

    @Override
    public int save(TaskRecord entity) {
        int result;
        if (entity.getRecordId() != null) {
            // The record does exist, update it
            TaskRecordDOExample example = new TaskRecordDOExample();
            example.createCriteria().andRecordIdEqualTo(Integer.valueOf(entity.getRecordId().getId()));
            result = taskRecordMapper.updateByExampleSelective(TaskRecordConvertor.convertToDO(entity), example);

        } else {
            // The record doesn't exist, insert it
            result = taskRecordMapper.insert(TaskRecordConvertor.convertToDO(entity));
        }
        return result;
    }

    @Override
    public int delete(EntityId entityId) {
        TaskRecordDOExample example = new TaskRecordDOExample();
        example.createCriteria().andRecordIdEqualTo(Integer.valueOf(entityId.getId()));
        return taskRecordMapper.deleteByExample(example);
    }

    @Override
    public List<TaskRecord> find(Set<TaskStatus> statusSet, Date exeTime) {
        List<String> statusList = statusSet.stream().map(TaskStatus::name).collect(Collectors.toList());
        TaskRecordDOExample example = new TaskRecordDOExample();
        example.createCriteria().andNextExeTimeLessThan(exeTime).andTaskStatusIn(statusList);
        return TaskRecordConvertor.convertFromDO(taskRecordMapper.selectByExample(example));
    }

    public TaskRecordMapper getTaskRecordMapper() {
        return taskRecordMapper;
    }

    public void setTaskRecordMapper(TaskRecordMapper taskRecordMapper) {
        this.taskRecordMapper = taskRecordMapper;
    }
}
