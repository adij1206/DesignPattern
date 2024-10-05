package com.aditya.DesignPattern.lld.onlineShoppingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private String userId;
    private String name;

    public User(String id, String name) {
        this.userId = id;
        this.name = name;
    }
}
