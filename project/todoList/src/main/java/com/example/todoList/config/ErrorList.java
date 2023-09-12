package com.example.todoList.config;

import org.springframework.stereotype.Component;

@Component
public class ErrorList {
    
    public static final String RECORD_NOT_FOUND = "Record not found";
    public static final String INVALID_REQUEST = "Invalid request";

    private ErrorList(){}
}
