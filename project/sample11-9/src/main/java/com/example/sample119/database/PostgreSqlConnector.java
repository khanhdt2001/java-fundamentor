package com.example.sample119.database;

public class PostgreSqlConnector extends DatabaseConnector{

    @Override
    public void connect() {
        System.out.println("Connect PostgreSql " + getUrl());
    }
    
}
