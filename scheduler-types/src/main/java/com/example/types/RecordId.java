package com.example.types;

public class RecordId implements EntityId {

    private Integer recordId;

    public RecordId(int recordId) {
        if (recordId <= 0) {
            throw new RuntimeException("The input parameter recordId is less than 0!");
        }
        this.recordId = recordId;
    }

    @Override
    public String getId() {
        return String.valueOf(recordId);
    }

    
}
