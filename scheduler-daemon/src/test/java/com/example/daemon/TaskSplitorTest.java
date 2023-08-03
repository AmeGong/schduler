package com.example.daemon;

import com.example.daemon.impl.TaskSplitorImpl;
import com.example.infra.repository.TaskRecordRepository;
import com.example.types.RecordId;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskSplitorTest {

    @InjectMocks
    private TaskSplitorImpl taskSplitorImpl;

    @Mock
    private TaskRecordRepository taskRecordRepository;


    @Mock
    private TaskExecutor taskExecutor;

    @org.junit.jupiter.api.Test
    void split() {
        when(taskRecordRepository.find(anySet(), any(Date.class))).thenReturn(Lists.newArrayList(new RecordId(1)));
        doThrow(new RuntimeException("Test")).
                when(taskExecutor).execute(anyList());
         assertThrows(RuntimeException.class, () ->{taskSplitorImpl.split(new Date());} );
//        taskSplitorImpl.split(new Date());
    }

}