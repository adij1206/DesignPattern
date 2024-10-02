package com.aditya.DesignPattern.lld.movieBookingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private String id;
    private String userName;

    public User(String userName) {
        this.id = UUID.randomUUID().toString();
        this.userName = userName;
    }
}
