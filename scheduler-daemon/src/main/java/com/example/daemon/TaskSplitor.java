package com.example.daemon;

import java.util.Date;
import java.util.List;

import com.example.types.EntityId;

public interface TaskSplitor {
    
    void split(Date exeTime);
}
