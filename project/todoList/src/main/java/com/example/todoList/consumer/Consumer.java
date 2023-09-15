package com.example.todoList.consumer;

import com.example.todoList.event.TaskEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @EventListener
    @Async
    public void logWhenAddTask(TaskEvent taskEvent)  throws InterruptedException {
        System.out.println("Consume Event");
        System.out.printf("Sender name %s", taskEvent.getSource().toString());
        System.out.printf("%s has been added%n", taskEvent.getTaskName());
    }
}
