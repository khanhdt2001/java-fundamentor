package com.example.todoList.event;

import org.springframework.context.ApplicationEvent;

public class TaskEvent extends ApplicationEvent {

    private final String taskName;
    public TaskEvent(Object source, String taskName) {
        super(source);
        this.taskName = taskName;
    }
    public String getTaskName() {
        return this.taskName;
    }
}
