package com.example.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyDog {
    
    @EventListener
    @Async
    public void doorBellEventListener(DoorBellEvent doorBellEvent) throws InterruptedException {
        System.out.println("CONSUM EVENT");
        // Giả sử con chó đang ngủ, 1 giây sau mới dậy
        Thread.sleep(1000);
        // Sự kiện DoorBellEvent được lắng nghe và xử lý tại đây
        System.out.println(Thread.currentThread().getName() + ": Chó ngủ dậy!!!");
        System.out.println(String.format("%s: Go go!! Có người tên là %s gõ cửa!!!", Thread.currentThread().getName(), doorBellEvent.getGuestName()));
    }
}
