package com.spring.boot.preparation.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "readiness")
public class ReadinessEndpoint {

    private String state = "not ready";

    @ReadOperation
    public String getReadiness() {
        return state;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setReadiness() {
        state = "ready";
    }
}
