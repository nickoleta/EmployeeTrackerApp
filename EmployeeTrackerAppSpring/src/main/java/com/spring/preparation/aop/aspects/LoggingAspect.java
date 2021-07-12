package com.spring.preparation.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.logging.Logger;

/**
 * What is Aspect Oriented Programming?
 * AOP aims to increase modularity by allowing the separation of cross-cutting concerns.
 * A cross-cutting concern is a behaviour that "cuts" across multiple application layers.
 * Examples of cross-cutting concerns: logging, error handling, localization, transaction handling,
 * monitoring (metrics), security(authorization and authentication).
 * An Aspect is the concert that "cuts" across multiple classes.
 * A Pointcut is an expression that matches a particular JoinPoint
 * A JoinPoint is a point during the execution of an app (for example method execution)
 * An Advice is the action taken by an Aspect at a particular JoinPoint, i.e. something like 'event handler'
 * There are different types of Advices: @Before, @After, @Around, @AfterReturning, @AfterThrowing
 */

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /**
     * A Pointcut starts with a PointcutDesignator (PCD). It is a keyword that tells Spring what should be matched.
     */
    // Example with 'execution'
    @Pointcut("execution(* com.spring.preparation.dao.impl.EmployeesDaoImpl.getAllEmployees())")
    public void getAllEmployeesPointcut() {
    }

    @Before("getAllEmployeesPointcut()")
    public void beforeGetAllEmployees() {
        logger.info("Before getAllEmployeesPointcut() method execution");
    }

    @After("getAllEmployeesPointcut()")
    public void afterGetAllEmployees(JoinPoint joinPoint) {
        logger.info("After getAllEmployeesPointcut() method execution");
    }

    @AfterThrowing(pointcut = "getAllEmployeesPointcut()")
    public void afterThrowingGetAllEmployees() {
        logger.info("Oooops..");
    }

    @AfterReturning("getAllEmployeesPointcut()")
    public void afterReturningGetAllEmployees() {
        logger.info("Successfully");
    }

    @Around("getAllEmployeesPointcut()")
    public Object aroundGetEmployeeByName(ProceedingJoinPoint proceedingJoinPoint) {
        logger.info("Start");
        Object proceed;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            return Collections.emptyList();
        }
        logger.info("End");
        return proceed;
    }

    // Example with 'within'
    @Pointcut("within(com.spring.preparation.service.impl.EmployeesServiceImpl)")
    public void everyMethodDefinedInEmployeesServiceImpl() {
    }

    @Before("everyMethodDefinedInEmployeesServiceImpl()")
    public void beforeEveryMethodDefinedInEmployeesServiceImpl() {
        logger.info("Before everyMethodDefinedInEmployeesServiceImpl() method execution");
    }

    // Example with 'target'
    @Pointcut("target(com.spring.preparation.service.EmployeesService)")
    public void everyClassThatImplementsEmployeesService() {
    }

    @Before("everyClassThatImplementsEmployeesService()")
    public void beforeEveryClassThatImplementsEmployeesService() {
        logger.info("Before everyClassThatImplementsEmployeesService() method execution");
    }

    // Example with execution of a method with template
    @Pointcut("execution(* *..*(String))")
    public void everyMethodThatTakesAStringAsAParameter() {
    }

    // Example with custom annotation
    @Pointcut("@annotation(com.spring.preparation.aop.aspects.Loggable)")
    public void everyMethodAnnotatedWithLoggableAnnotation() {
    }

    @Before("everyMethodAnnotatedWithLoggableAnnotation()")
    public void beforeEveryMethodAnnotatedWithLoggableAnnotation() {
        logger.info("Before everyMethodAnnotatedWithLoggableAnnotation() method execution");
    }
}
