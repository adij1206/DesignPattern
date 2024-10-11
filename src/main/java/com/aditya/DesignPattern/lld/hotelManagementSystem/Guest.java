package com.aditya.DesignPattern.lld.hotelManagementSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Guest {

    private String id;
    private String name;
    private String phoneNumber;

    public Guest(String name, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
