package com.example.todoList.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Todo geTodo(@PathVariable(name = "todoId") Integer todoId) {
        return todoService.getById(todoId);
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
}
