package com.example.todoList.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "todos")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String detail;

   @ManyToOne
   @JoinColumn(name = "user_id", nullable = false)
   @EqualsAndHashCode.Exclude
   @ToString.Exclude
   @JsonIgnoreProperties(value = {"todos"})
   private User user;

}
