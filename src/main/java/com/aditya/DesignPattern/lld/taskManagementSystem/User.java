package com.aditya.DesignPattern.lld.taskManagementSystem;

import lombok.Data;

@Data
public class User {

    private String email;
    private String name;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
