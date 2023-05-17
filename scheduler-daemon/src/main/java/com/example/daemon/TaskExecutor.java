package com.example.daemon;

import java.util.List;

import com.example.types.EntityId;

public interface TaskExecutor {
    

    /**
     * process the entity
     * this method cannot throw any runtime exception
     * @param entityIdList
     * @return
     */
    void execute(List<EntityId> entityIdList);
}
