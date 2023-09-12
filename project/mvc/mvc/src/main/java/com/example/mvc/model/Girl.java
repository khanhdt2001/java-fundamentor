package com.example.mvc.model;

public class Girl extends Human {

    public Girl(String name) {
       super(name);
    }

    @Override
    public String toString() {
        return "Girl(" + this.getName() + ")";
    }
}
