package com.example.types;

public class RecordId implements EntityId {

    private Integer recordId;

    RecordId(Integer recordId) {
        if (recordId == null) {
            throw new RuntimeException("The input paramter recordId is null!");
        }
        this.recordId = recordId;
    }

    @Override
    public String getId() {
        return String.valueOf(recordId);
    }

    
}
