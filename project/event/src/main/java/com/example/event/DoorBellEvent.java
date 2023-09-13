package com.example.event;

import org.springframework.context.ApplicationEvent;

public class DoorBellEvent extends ApplicationEvent  {

    private String guestName;

    public DoorBellEvent(Object source, String guestName) {
        super(source);
        this.guestName = guestName;
    }

    public Object getGuestName() {
        return this.guestName;
    }
    
}
