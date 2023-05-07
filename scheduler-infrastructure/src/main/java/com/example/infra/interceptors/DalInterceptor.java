package com.example.infra.interceptors;

import com.example.domain.util.LogDef;
import org.aopalliance.intercept.MethodInterceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class DalInterceptor implements MethodInterceptor {
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
            LogDef.DAL_DIGIEST.info(String.format("Elapsed time %d ms, %s#%s", endTime - startTime, className, methodName));
        }
        return result;

    }

}
