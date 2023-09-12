package com.example.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.mvc.model.Children;
import com.example.mvc.model.Girl;
import com.example.mvc.service.GirlService;

@ComponentScan("com.example.mvc.model")
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        try {
            // Lấy ra bean GirlService
            GirlService girlService = context.getBean(GirlService.class);
            // Lấu ra random một cô gái từ tầng service
            Girl girl = girlService.getRandomGirl();
            // In ra màn hình
            System.out.println(girl);
            
        } catch (Exception e) {
            System.out.println("Bean Girl not found");
        }



        try {
            Children childrenExample = context.getBean(Children.class);
            System.out.println(childrenExample.toString());
        } catch (Exception e) {
            System.out.println("Bean Children không tồn tại");
        }
        try {
            Man manExample = context.getBean(Man.class);
            System.out.println(manExample.toString());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Bean Man không tồn tại");
        }
    }
}
