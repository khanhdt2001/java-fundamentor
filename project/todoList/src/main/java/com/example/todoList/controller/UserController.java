package com.example.todoList.controller;

import com.example.todoList.model.User;
import com.example.todoList.service.JwtTokenProvider;
import com.example.todoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.jaas.LoginExceptionResolver;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @GetMapping("/{userId}")
    public User getUserDetail(@PathVariable(name = "userId") Long userId) throws Exception {
        try {
            return userService.getUserDetailById(userId);
        } catch (Exception e) {
            throw e;
        }
    }
    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody User user) throws Exception {
        userService.add(user);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/login")
    public LoginExceptionResolver authenticateUser(@Validated @RequestBody LoginRequest)
}
