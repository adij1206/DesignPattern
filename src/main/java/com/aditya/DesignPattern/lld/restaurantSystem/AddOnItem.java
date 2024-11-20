package com.aditya.DesignPattern.lld.restaurantSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class AddOnItem {

    private String id;
    private String menuItemId;
    private String name;
    private Boolean available;
    private Double price;

    public AddOnItem(String name, Double price, String menuItemId) {
        this.id = UUID.randomUUID().toString();
        this.menuItemId = menuItemId;
        this.name = name;
        this.available = true;
        this.price = price;
    }
}
