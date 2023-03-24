package com.example.infrastructure;


import com.example.Bootstrap;
import com.example.domain.entity.TaskRecord;
import com.example.infra.dao.auto.TaskRecordMapper;
import com.example.infra.po.TaskRecordDO;
import com.example.infra.repository.TaskRecordRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Bootstrap.class)
@ActiveProfiles("test")
//@MybatisTest
//@TestPropertySource(
//  locations = "classpath:application-test.properties")
public class TaskRecordRepositoryTest {

    @Autowired
    private TaskRecordRepository taskRecordRepository;


    @Autowired
    private TaskRecordMapper taskRecordMapper;

    @Test
    public void saveTest() {
        TaskRecordDO row = new TaskRecordDO();
        row.setTaskContext("taskContext");
        System.out.println(taskRecordMapper.insert(row));
    }
    
}
