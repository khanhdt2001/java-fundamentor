package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Man {
    @Autowired
    @Qualifier("bikini")
    Outfit outfit;

    public Man(Outfit outfit) {
        this.outfit = outfit;
    }
}
