package com.example.types;

import org.springframework.util.StringUtils;

public class RecordId implements EntityId {

    private String recordId;

    RecordId(String recordId) {
        if (StringUtils.isEmpty(recordId)) {
            throw new RuntimeException("The input paramter recordId is empty!");
        }
        this.recordId = recordId;
    }

    @Override
    public String getId() {
        return recordId;
    }

    
}
