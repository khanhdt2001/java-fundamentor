package com.example.todoList.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.todoList.config.ErrorList;
import com.example.todoList.model.ErrorMessage;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity <ErrorMessage> handleAllException(Exception ex, WebRequest request) {
        switch( ex.getLocalizedMessage()) {
            case ErrorList.RECORD_NOT_FOUND :
            return new ResponseEntity<ErrorMessage>( 
                new ErrorMessage(
                    HttpStatus.NOT_FOUND.value(), 
                    10000,
                    ErrorList.RECORD_NOT_FOUND), 
                    HttpStatus.NOT_FOUND);

            case ErrorList.INVALID_REQUEST:
            return new ResponseEntity<ErrorMessage>( 
                new ErrorMessage(
                    HttpStatus.BAD_REQUEST.value(), 
                    2000,
                    ErrorList.INVALID_REQUEST), 
                    HttpStatus.BAD_REQUEST);
                    
            default:
            return new ResponseEntity<ErrorMessage>(
                new ErrorMessage(
                    HttpStatus.NOT_FOUND.value(), 
                    10000,
                    ErrorList.RECORD_NOT_FOUND),
                    HttpStatus.NOT_FOUND);
        }
       
    }

}
