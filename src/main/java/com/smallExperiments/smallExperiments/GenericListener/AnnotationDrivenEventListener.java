package com.smallExperiments.smallExperiments.GenericListener;
import com.smallExperiments.smallExperiments.model.GenericSpringEvent;
import io.micrometer.common.lang.NonNull;
import org.springframework.context.ApplicationListener;
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