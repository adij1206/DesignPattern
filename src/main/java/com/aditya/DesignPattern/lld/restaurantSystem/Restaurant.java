package com.aditya.DesignPattern.lld.restaurantSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Restaurant {

    private String id;
    private String name;
    private String address;

    public Restaurant(String name, String address) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
    }
}
