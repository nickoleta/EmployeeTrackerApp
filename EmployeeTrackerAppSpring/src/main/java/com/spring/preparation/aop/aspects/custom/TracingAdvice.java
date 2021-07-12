package com.spring.preparation.aop.aspects.custom;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class TracingAdvice implements MethodBeforeAdvice {

    private final Logger logger = Logger.getLogger(TracingAdvice.class.getName());

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        logger.info("Custom Before Advice has been executed.");
    }
}
