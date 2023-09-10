package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Children  {
    
    @Autowired
    Outfit outfit;

    public Children(Outfit outfit) {
        this.outfit = outfit;
    }
}
