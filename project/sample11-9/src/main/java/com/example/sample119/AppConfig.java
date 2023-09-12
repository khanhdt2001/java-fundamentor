package com.example.sample119;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.sample119.database.DatabaseConnector;
import com.example.sample119.database.MySqlConnector;
import com.example.sample119.database.PostgreSqlConnector;

@Configuration
public class AppConfig {
    
    @Bean("mysqlConnector")
    DatabaseConnector mysqlConfig() {
        DatabaseConnector mysqlConnector = new MySqlConnector();
        mysqlConnector.setUrl("mysqlConfig url");
        return mysqlConnector;
    }

    @Bean("postgreSqlConnector")
    DatabaseConnector postgreSqlConfig() {
        DatabaseConnector postgresSqlConnector = new PostgreSqlConnector();
        postgresSqlConnector.setUrl("postgreSqlConfig url");
        System.out.println(postgresSqlConnector.getUrl()); 
        return postgresSqlConnector;
    }
}
