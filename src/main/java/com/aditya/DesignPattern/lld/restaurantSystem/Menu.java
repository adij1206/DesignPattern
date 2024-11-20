package com.aditya.DesignPattern.lld.restaurantSystem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Menu {

    private String id;
    private String restaurantId;
    private List<MenuItem> menuItems;

    public Menu(String restaurantId) {
        this.id  = UUID.randomUUID().toString();
        this.restaurantId = restaurantId;
        this.menuItems = new ArrayList<>();
    }
}
