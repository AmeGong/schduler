package com.example.infra.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.example.domain.entity.TaskRecord;
import com.example.types.EntityId;
import com.example.types.RecordId;
import com.example.types.enums.TaskStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TaskRecordRepository extends Repository<TaskRecord, RecordId> {

    /**
     * Find all the TaskRecord where its status is in the statusSet and its nextExeTime is before the exeTime;
     * @param statusSet
     * @param exeTime
     * @param limit
     * @return the primary keys
     */
    List<EntityId> find(@NotEmpty Set<TaskStatus> statusSet, @NotNull Date exeTime, int limit);

    /**
     * Find all the TaskRecord where its status is in the statusSet and its nextExeTime is before the exeTime;
     * @param statusSet
     * @param exeTime
     * @return the primary keys
     */
    List<EntityId> find(@NotEmpty Set<TaskStatus> statusSet, @NotNull Date exeTime);

    /**
     * optimistic lock by the task status
     * @param entityId
     * @param previousStatus
     * @param targetStatus
     * @return
     */
    boolean optimisticLockByStatus(@NotNull EntityId entityId, @NotNull TaskStatus previousStatus, @NotNull TaskStatus targetStatus);
}
