package com.spring.common.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
@Component("loggingAspect")
public class LoggingAspect implements MethodInterceptor {
	protected final Log logger = LogFactory.getLog(getClass());
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName=invocation.getMethod().getName();
		logger.debug(String.format("##### %s 호출 전",methodName));
		Object obj=invocation.proceed();
		logger.debug(String.format("##### %s 호출 후",methodName));
		
		return obj;
	}

}

