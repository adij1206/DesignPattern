package com.aditya.DesignPattern.lld.foodDeliverySystem;

import lombok.Data;

import java.util.UUID;

@Data
public class DeliveryAgent {

    private String id;
    private String name;
    private boolean isAvailable;

    public DeliveryAgent(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.isAvailable = true;
    }
}
