package com.example.sample119.database;

public class MySqlConnector extends DatabaseConnector{

    @Override
    public void connect() {
        System.out.println("Connect to MySqlDb " + this.getUrl());
    }
    
}
