package com.example.sample119;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.sample119.database.DatabaseConnector;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        DatabaseConnector mysql = (DatabaseConnector) context.getBean("mysqlConnector");
        mysql.connect();

        DatabaseConnector postgresql = (DatabaseConnector) context.getBean("postgreSqlConnector");
        System.out.println("hello " +postgresql.getUrl());
        postgresql.connect();
    }
}
