package com.smallExperiments.smallExperiments.model;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class CustomSpringAsync extends ApplicationEvent {
    private String message;

    public CustomSpringAsync(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
