package com.example.infra.interceptors;

import org.aopalliance.intercept.MethodInterceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class DalInterceptor implements MethodInterceptor {

    protected static Log LOG = LogFactory.getLog("DAL_DIGEST");

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        String className = invocation.getMethod().getDeclaringClass().getSimpleName();
        String methodName = invocation.getMethod().getName();
        Object result = null;
        try {
            result = invocation.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            LOG.info(String.format("cost %d ms, %s#%s", endTime - startTime, className, methodName));
        }
        return result;

    }

}
