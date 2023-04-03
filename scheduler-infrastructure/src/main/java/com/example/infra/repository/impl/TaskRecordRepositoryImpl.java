package com.example.infra.repository.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.example.domain.entity.TaskRecord;
import com.example.infra.convertor.TaskRecordConvertor;
import com.example.infra.dao.auto.TaskRecordMapper;
import com.example.infra.dao.manual.TaskRecordManualMapper;
import com.example.infra.po.TaskRecordDO;
import com.example.infra.po.TaskRecordDOExample;
import com.example.infra.repository.TaskRecordRepository;
import com.example.types.EntityId;
import com.example.types.RecordId;
import com.example.types.enums.TaskStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

@Repository
public class TaskRecordRepositoryImpl implements TaskRecordRepository {

    private final int MAX_LIMIT = 500;

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
        TaskRecordDOExample example = new TaskRecordDOExample();
        example.createCriteria().andRecordIdEqualTo(Integer.valueOf(entityId.getId()));
        List<TaskRecordDO> result = taskRecordMapper.selectByExample(example);
        return CollectionUtils.isEmpty(result) ? null : TaskRecordConvertor.convertFromDO(result.get(0));
    }

    @Override
    public int save(TaskRecord entity) {
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
        TaskRecordDOExample example = new TaskRecordDOExample();
        example.createCriteria().andRecordIdEqualTo(Integer.valueOf(entityId.getId()));
        return taskRecordMapper.deleteByExample(example);
    }

    @Override
    public List<EntityId> find(Set<TaskStatus> statusSet, Date exeTime, int limit) {
        List<String> statusList = statusSet.stream().map(TaskStatus::name).collect(Collectors.toList());
        limit = Math.min(limit, MAX_LIMIT);
        TaskRecordDOExample example = new TaskRecordDOExample();
        example.createCriteria().andNextExeTimeLessThanOrEqualTo(exeTime).andTaskStatusIn(statusList);
        example.setOrderByClause(" record_id limit "+ limit);
        return taskRecordMapper.selectByExample(example).stream()
                .map(itme -> new RecordId(itme.getRecordId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<EntityId> find(Set<TaskStatus> statusSet, Date exeTime) {
        return find(statusSet,exeTime,MAX_LIMIT);
    }

    @Override
    public boolean optimisticLockByStatus(EntityId entityId, TaskStatus previousStatus,
            TaskStatus targetStatus) {
        return taskRecordManualMapper.optimisticLockByTaskStats(Integer.valueOf(entityId.getId()), previousStatus.name(), targetStatus.name()) == 1;
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
