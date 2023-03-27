package com.example.domain.entity;


import com.example.types.EntityId;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public interface BaseEntity<K extends EntityId> {

    public static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    default void validate() {
        Set<ConstraintViolation<BaseEntity<K>>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
    
}
