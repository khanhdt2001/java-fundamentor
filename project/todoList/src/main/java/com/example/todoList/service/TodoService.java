package com.example.todoList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.todoList.model.Todo;
import com.example.todoList.model.TodoValidator;
import com.example.todoList.repository.TodoRepository;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoValidator validator;


    public List<Todo> findAll(Integer limit) {
        return Optional.ofNullable(limit)
        .map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
        .orElseGet(() -> todoRepository.findAll());
    }

    public Todo getById(Integer todoId) {
        
        return todoRepository.finTodoById(todoId);
        
    }

    public Todo add(Todo todo) {
        if (validator.isValid(todo)) {
            return todoRepository.save(todo);
        }
        return null;
    }

    public void removeTodo(Long todoId) {
        try {
            todoRepository.deleteById(todoId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
