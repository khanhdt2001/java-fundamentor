package com.example.todoList.repository;

import com.example.todoList.model.Todo;
import com.example.todoList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
    @Query(value = "select * from users u where u.id = :userId", nativeQuery = true)
    User findUserDetail(@Param("userId") Long userId);

    User findUserByUsername(String username);
}
