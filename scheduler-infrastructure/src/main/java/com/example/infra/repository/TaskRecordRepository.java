package com.example.infra.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.example.domain.entity.TaskRecord;
import com.example.types.RecordId;
import com.example.types.enums.TaskStatus;

public interface TaskRecordRepository extends Repository<TaskRecord, RecordId> {

    /**
     * Find all the TaskRecord where its status is in the statusSet and its nextExeTime is before the exeTime;
     * @param statusSet
     * @param exeTime
     * @return
     */
    List<Integer> find(Set<TaskStatus> statusSet, Date exeTime);
}
