package com.smallExperiments.smallExperiments.EventListenerExample.GenericListener;

import com.smallExperiments.smallExperiments.EventListenerExample.model.GenericSpringEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class GenericEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public GenericEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public <T> void publishEvent(final T event, boolean success) {
        System.out.println("Publishing event - " + event + ", Success: " + success);
        GenericSpringEvent<T> genericSpringEvent = new GenericSpringEvent<>(event, success);
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }
}
