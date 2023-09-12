package com.example.todoList;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        // userRepository.findAll().forEach(System.out::println);

        // User user = userRepository.save(new User());
        // // Khi lưu xong, nó trả về User đã lưu kèm theo Id.
        // System.out.println("User vừa lưu có ID: " + user.getId());
        // Long userId = user.getId();
        // // Cập nhật user.
        // user.setAgi(100);
        // userRepository.save(user);

        // // Query lấy ra user vừa xong để kiểm tra xem.
        // User user2 = userRepository.findById(userId).get();
        // System.out.println("User: " + user);
        // System.out.println("User2: " + user2);


        // System.out.println("\n Tìm user với Agi trong khoảng (25 - 30)");
        // System.out.println("findAllByAgiBetween: ");
        // userRepository.findAllByAgiBetween(25, 30)
        //               .forEach(System.out::println);

        // System.out.println("===========================================");
        // System.out.println("Tìm User với def = 49");
        // User user = userRepository.findUserByDefSQLQuery(49);
        // System.out.println("User: " + user);

        // System.out.println("===========================================");
        // System.out.println("Tìm User với def = 50");
        // User user1 = userRepository.findUserByDefQuery(50);
        // System.out.println("User: " + user1);
    }
}
