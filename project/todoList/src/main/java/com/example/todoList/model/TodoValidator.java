package com.example.todoList.model;

import java.util.Optional;
import org.thymeleaf.util.StringUtils;

public class TodoValidator {
    public boolean isValid(Todo todo) {
        boolean isValid = Optional.ofNullable(todo)
        .filter(t -> !StringUtils.isEmpty(t.getTitle())) 
        .filter(t -> !StringUtils.isEmpty(t.getDetail()))
        .isPresent();
        return  isValid;
    }
}
