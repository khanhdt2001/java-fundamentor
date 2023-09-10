package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);


        Girl girl = context.getBean(Girl.class);

        System.out.println("Girl Instance: " + girl);

        System.out.println("Girl Outfit: " + girl.outfit);

        girl.outfit.wear();


        Man man = context.getBean(Man.class);
        
        System.out.println("Man Instance: " + man);

        System.out.println("Man Outfit: " + man.outfit);

        man.outfit.wear();

        Children children = context.getBean(Children.class);
        children.outfit.wear();

    }
}