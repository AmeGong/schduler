package com.example.types.enums;

import java.util.HashSet;

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
    
}
