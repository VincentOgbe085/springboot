package com.example.payments.demo_payments.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceLoggingAspect {

    Logger logger = LoggerFactory.getLogger(ServiceLoggingAspect.class);

    @Pointcut("execution(* com.neueda.payments.service.*.* (..))")
    public void logServiceMethods() {}

    @Before("logServiceMethods()")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        logger.info("{} was called", joinPoint.getSignature() );
    }
    @After("logServiceMethods()")
    public void afterLogServiceMethods(JoinPoint joinPoint) {
        logger.info("exiting {}", joinPoint.getSignature());
    }
}
