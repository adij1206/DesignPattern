package com.aditya.DesignPattern.lld.foodDeliverySystem;

import lombok.Data;

import java.util.UUID;

@Data
public class MenuItem {

    private String id;
    private String name;
    private String description;
    private double price;

    public MenuItem(String name, String description, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
