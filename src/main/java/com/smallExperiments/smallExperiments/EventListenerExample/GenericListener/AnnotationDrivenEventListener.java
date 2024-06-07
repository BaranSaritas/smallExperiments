package com.smallExperiments.smallExperiments.EventListenerExample.GenericListener;
import com.smallExperiments.smallExperiments.EventListenerExample.model.GenericSpringEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationDrivenEventListener {
    @EventListener(value = GenericSpringEvent.class, condition = "#event.success")
    public void handleSuccessful(GenericSpringEvent<String> event) {
        System.out.println("Handling generic event."+event.isSuccess());
    }
}

// tek basina sadece condition kullanarak algilamasi zor oluyor gelis tipini value icinde belirtmek gerekiyor