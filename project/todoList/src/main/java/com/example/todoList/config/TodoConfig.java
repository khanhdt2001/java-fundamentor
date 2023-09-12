package com.example.todoList.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.todoList.model.TodoValidator;

@Configuration
public class TodoConfig {
    
    @Bean
    public TodoValidator validator(){
        return new TodoValidator();
    }
}
