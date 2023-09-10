package com.example.mvc.model;

public class Human {
    private String name;
    public Human(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human(" + this.name + ")";
    }

}
