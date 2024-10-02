package com.aditya.DesignPattern.lld.foodDeliverySystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Customer {

    private String id;
    private String name;

    public Customer(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
