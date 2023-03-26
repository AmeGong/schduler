package com.example.types.enums;

public enum TaskType {
    
    DEMO(10, "Demo Task"),
    ;

    private int maxRetryTimes;

    private String desc;

    TaskType(int maxRetryTime, String desc) {
        this.maxRetryTimes = maxRetryTimes;
        this.desc = desc;
    }

    public int getMaxRetryTimes() {
        return maxRetryTimes;
    }

    public void setMaxRetryTimes(int maxRetryTimes) {
        this.maxRetryTimes = maxRetryTimes;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    

}
