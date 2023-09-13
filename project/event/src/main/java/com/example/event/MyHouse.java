package com.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyHouse {
    
    @Autowired
    ApplicationEventPublisher applicationEventPublisher; 

    public void rangDoorbellBy(String guestName) {
        // Phát ra một sự kiện DoorBellEvent
        // source (Nguồn phát ra) chính là class này
        System.out.println("PUBLISH NEW EVENT");
        applicationEventPublisher.publishEvent(new DoorBellEvent(this, guestName));
    }
}
