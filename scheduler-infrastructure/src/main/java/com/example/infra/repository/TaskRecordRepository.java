package com.example.infra.repository;

import java.util.List;

import com.example.domain.entity.TaskRecord;
import com.example.infra.convertor.TaskRecordConvertor;
import com.example.infra.dao.auto.TaskRecordMapper;
import com.example.infra.po.TaskRecordDO;
import com.example.infra.po.TaskRecordDOExample;
import com.example.types.EntityId;
import com.example.types.RecordId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

@org.springframework.stereotype.Repository
public class TaskRecordRepository implements Repository<TaskRecord, RecordId> {

    @Autowired
    private TaskRecordMapper taskRecordMapper;

    @Override
    public List<TaskRecord> find(TaskRecord entity) {
        // TODO
        TaskRecordDOExample example = new TaskRecordDOExample();
        return TaskRecordConvertor.convertFromDO(taskRecordMapper.selectByExample(example));
    }

    @Override
    public TaskRecord find(EntityId entityId) {
        TaskRecordDOExample example = new TaskRecordDOExample();
        example.createCriteria().andRecordIdEqualTo(Integer.valueOf(entityId.getId()));
        List<TaskRecordDO> result =taskRecordMapper.selectByExample(example);
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
}
