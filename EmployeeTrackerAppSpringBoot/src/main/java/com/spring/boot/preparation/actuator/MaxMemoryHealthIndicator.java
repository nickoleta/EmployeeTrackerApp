package com.spring.boot.preparation.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MaxMemoryHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        final boolean invalid = Runtime.getRuntime().maxMemory() < (100 * 1024 * 1024);
        final Status status = invalid ? Status.DOWN : Status.UP;
        return Health.status(status).build();
    }
}
