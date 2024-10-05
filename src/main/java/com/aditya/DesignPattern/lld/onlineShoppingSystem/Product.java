package com.aditya.DesignPattern.lld.onlineShoppingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Product {

    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(String name, String description, double price, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}
