package com.example.daemon;

import java.util.List;

import com.example.types.EntityId;

public interface TaskExecutor {
    

    /**
     * process the entity
     * @param entityIdList
     * @return
     */
    void execute(List<EntityId> entityIdList);
}
