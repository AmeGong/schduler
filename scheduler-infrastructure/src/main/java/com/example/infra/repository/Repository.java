package com.example.infra.repository;

import com.example.domain.entity.BaseEntity;
import com.example.types.EntityId;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;


@Validated
public interface Repository<T extends BaseEntity<K>, K extends EntityId> {

    /**
     * find the entity
     * @param entity
     * @return
     */
    List<T> find(@NotNull T entity);

    /**
     * find the entity by its entityId
     */
    T find(@NotNull EntityId entityId);

    /**
     * lock the entity by its entityId
     */
    T lock(@NotNull EntityId entityId, boolean silenceMode);

    /**
     * save the entity
     * if the entity doesn't exist, then insert the entity
     * if the entity does exist, then update the entity by entityId
     * @param entity
     * @return
     */
    int save(@NotNull T entity);

    /**
     * delete the entity by its entityId
     */
    int delete(@NotNull EntityId entityId);
}
