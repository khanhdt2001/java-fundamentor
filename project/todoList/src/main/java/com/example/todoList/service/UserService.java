package com.example.todoList.service;

import com.example.todoList.model.CustomUserDetails;
import com.example.todoList.model.User;
import com.example.todoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public User add(User user) throws Exception {
        return userRepository.save(user);
    }
    public User getUserDetailById(Long userId) {
        User user = userRepository.findUserDetail(userId);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    public UserDetails loadUserById(Long userId) throws UsernameNotFoundException {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new UsernameNotFoundException(userId.toString());
        }
        return new CustomUserDetails(user);
    }
}
