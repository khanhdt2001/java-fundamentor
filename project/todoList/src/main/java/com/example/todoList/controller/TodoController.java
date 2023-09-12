package com.example.todoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoList.model.Todo;
import com.example.todoList.service.TodoService;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todo")
    public List<Todo> getTodoList() {
        List<Todo> listTodo = todoService.findAll(10);
        return listTodo;
    }

    @GetMapping("/todo/{todoId}")
    public Todo geTodo(@PathVariable(name = "todoId") Integer todoId) throws Exception {
        try {
            Todo todo = todoService.getById(todoId);
            return todo;
        } catch (Exception e) {
            throw e;
        }

    }

    @PostMapping("/todo")
    public ResponseEntity<?> addTodo(@RequestBody Todo todo)  {
        todoService.add(todo);
        return ResponseEntity.ok().body(todo);
    }
    
    
    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable(name = "todoId") Long todoId) {
        todoService.removeTodo(todoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestHeader HttpHeaders headers ) {
        return ResponseEntity.ok().body(headers);
    }
}
