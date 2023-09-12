package com.example.todoList.model;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErrorMessage   {
    private int statusCode;
    private int devStatusCode;
    private String message;
}
