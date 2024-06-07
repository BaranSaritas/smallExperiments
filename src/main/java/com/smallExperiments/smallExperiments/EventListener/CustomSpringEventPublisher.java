package com.smallExperiments.smallExperiments.EventListener;

import com.smallExperiments.smallExperiments.model.CustomSpringEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public CustomSpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    public void publishCustomEvent(final String message) {
        System.out.println("Publishing event : "+ message);
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}