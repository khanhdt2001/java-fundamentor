package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Children  {
    
    @Autowired
    Outfit outfit;

    public Children(Outfit outfit) {
        this.outfit = outfit;
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("\n Children postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("\n Children preDestroy");
    }
}
