package com.example.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.todoList.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    @Query(value = "select * from todos t where t.id = :todoId", nativeQuery = true)
    Todo finTodoById(@Param("todoId") Integer todoId);
}
