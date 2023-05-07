package com.example.app.service.spi;

import com.example.domain.entity.TaskRecord;
import com.example.domain.service.AbstractTaskProcessorSpi;
import com.example.types.enums.TaskType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoTaskProcessorSpi extends AbstractTaskProcessorSpi {

    private static final Log LOG = LogFactory.getLog(DemoTaskProcessorSpi.class);
    @Override
    public TaskType supportTaskType() {
        return TaskType.DEMO;
    }

    @Override
    public boolean process(TaskRecord taskRecord) {
        LOG.info(taskRecord.getRecordId());
        return true;
    }
}
