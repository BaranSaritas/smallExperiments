package com.smallExperiments.smallExperiments.EventListenerExample.AsyncEventListener;

import com.smallExperiments.smallExperiments.EventListenerExample.model.CustomSpringAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventPublisherAsync {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    public void publishCustomEvent(final String message) {
        System.out.println("Publishing custom event. ");
        CustomSpringAsync customSpringEvent= new CustomSpringAsync(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
