package com.spring.preparation.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLifecycle implements BeanNameAware, BeanFactoryAware, BeanPostProcessor, InitializingBean, DisposableBean {

    /** Bean Creation Phases: */

    /**
     * Aware interfaces
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware interface's method was invoked.");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware interface's method was invoked.");
    }

    /** BeanPostProcessor's postProcessBeforeInitialization() method */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor's postProcessBeforeInitialization() method was invoked.");
        return bean;
    }

    /** InitializingBean's method */
    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean's afterPropertiesSet() method was invoked.");
    }

    /** @PostConstruct and @PreDestroy annotations are part of Java EE. And since Java EE has been deprecated in Java 9 and removed in Java 11
    we have to add an additional dependency to use these annotations - javax.annotation-api */
    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct annotated method was invoked.");
    }

    /** Custom init() method */
    public void onInitialize() {
        System.out.println("Custom init method was invoked.");
    }



    /** Bean Destruction Phases: */

    /** BeanPostProcessor's postProcessAfterInitialization() method */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor's postProcessBeforeInitialization() method was invoked.");
        return bean;
    }

    /** DisposableBean's destroy() method */
    @Override
    public void destroy() {
        System.out.println("DisposableBean's destroy() method was invoked.");
    }

    /** @PostConstruct and @PreDestroy annotations are part of Java EE. And since Java EE has been deprecated in Java 9 and removed in Java 11
    we have to add an additional dependency to use these annotations - javax.annotation-api */
    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy annotated method was invoked.");
    }

    /** Custom destroy implementation */
    public void onDestroy() {
        System.out.println("Custom destroy() method was invoked.");
    }
}
