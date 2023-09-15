package com.example.todoList.service;

import java.util.List;
import java.util.Optional;

import com.example.todoList.event.TaskEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.todoList.config.ErrorList;
import com.example.todoList.model.Todo;
import com.example.todoList.model.TodoValidator;
import com.example.todoList.repository.TodoRepository;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoValidator validator;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    public List<Todo> findAll(Integer limit) {
        return Optional.ofNullable(limit)
        .map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
        .orElseGet(() -> todoRepository.findAll());
    }

    public Todo getById(Integer todoId) throws Exception{
        Todo todo = todoRepository.finTodoById(todoId);
        if (todo == null) {
            throw new Exception(ErrorList.RECORD_NOT_FOUND);
        }
        return todo;
        
    }

    public Todo add(Todo todo) throws Exception {
        if (validator.isValid(todo)) {
            applicationEventPublisher.publishEvent(new TaskEvent(this, todo.getTitle()));
            return todoRepository.save(todo);
        }
        throw new Exception(ErrorList.INVALID_REQUEST);
    }

    public void removeTodo(Long todoId) {
        try {
            todoRepository.deleteById(todoId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Page<Todo> getTotoCustom(Integer page, Integer pageSize) {
        Page<Todo> response = todoRepository.findAll(PageRequest.of(page, pageSize));
        return response;
    }

}
