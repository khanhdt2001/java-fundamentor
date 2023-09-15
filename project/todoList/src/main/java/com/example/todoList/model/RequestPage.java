package com.example.todoList.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestPage {
    private int pageNumber;
    private int pageSize;
}
