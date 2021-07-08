package com.spring.preparation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("custom.properties") // @PropertySource annotation cannot be used with YAML files!
public class ApplicationProperties {

    @Value("${application.name}")
    private String applicationName;

    public String getApplicationName() {
        return applicationName;
    }
}
