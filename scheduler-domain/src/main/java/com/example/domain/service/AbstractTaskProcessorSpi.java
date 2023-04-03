package com.example.domain.service;

import org.springframework.beans.factory.InitializingBean;

public abstract class AbstractTaskProcessorSpi implements InitializingBean, TaskProcessorSpi {

    @Override
    public void afterPropertiesSet() throws Exception {
        TaskProcessorSpiFactory.registry(this);
    }
}
