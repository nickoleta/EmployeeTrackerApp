package com.spring.preparation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class BeanLifecycleConfig {

    @Profile("dev")
    @Bean(initMethod = "onInitialize", destroyMethod = "onDestroy")
    public BeanLifecycle beanLifecycle() {
        return new BeanLifecycle();
    }
}
