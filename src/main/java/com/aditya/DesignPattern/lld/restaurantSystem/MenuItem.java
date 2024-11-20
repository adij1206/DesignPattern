package com.aditya.DesignPattern.lld.restaurantSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class MenuItem {

    private String id;
    private String menuId;
    private String name;
    private String description;
    private Double price;
    private Boolean available;

    public MenuItem(
            String menuId, String name, String description, Double price
    ) {
        this.id = UUID.randomUUID().toString();
        this.menuId = menuId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = true;
    }
}
