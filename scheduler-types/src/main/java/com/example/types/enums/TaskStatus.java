package com.example.types.enums;

public enum TaskStatus {


    INITIAL,
    COMPLETED,
    PROCESSING,
    ERROR,
    /*
     * The record fails to execute for lacking some resources
     */
    WAITING,
    ;

    public static TaskStatus getByCode(String code) {
        TaskStatus[] values = values();
        for (TaskStatus value : values) {
            if (value.name().equals(code)) {
                return value;
            }
        }
        return null;
    }
    
}
