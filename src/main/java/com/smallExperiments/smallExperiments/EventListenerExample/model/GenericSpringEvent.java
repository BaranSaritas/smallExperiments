package com.smallExperiments.smallExperiments.EventListenerExample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class GenericSpringEvent<T> {
    private T what;
    private boolean success;

    public GenericSpringEvent(T what, boolean success) {
        this.what = what;
        this.success = success;
    }

}