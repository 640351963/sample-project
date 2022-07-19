package com.example.springbootsample.core.runner;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyReadinessStateExporter {

    @EventListener
    public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
        switch (event.getState()) {
            case ACCEPTING_TRAFFIC:
                System.out.println("ACCEPTING_TRAFFIC->");
                // create file /tmp/healthy
                break;
            case REFUSING_TRAFFIC:
                System.out.println("REFUSING_TRAFFIC->");
                // remove file /tmp/healthy
                break;
        }
    }


}
