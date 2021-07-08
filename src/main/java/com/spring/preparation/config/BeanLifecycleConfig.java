package com.spring.preparation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanLifecycleConfig {

    @Bean(initMethod = "onInitialize", destroyMethod = "onDestroy")
    public BeanLifecycle beanLifecycle() {
        return new BeanLifecycle();
    }
}
