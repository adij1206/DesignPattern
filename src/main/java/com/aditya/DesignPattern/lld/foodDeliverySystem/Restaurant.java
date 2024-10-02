package com.aditya.DesignPattern.lld.foodDeliverySystem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Restaurant {

    private String id;
    private List<String> menuIds;
    private String name;

    public Restaurant(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.menuIds = new ArrayList<>();
    }

    public void addMenuId(String menuId) {
        this.menuIds.add(menuId);
    }

    public void removeMenuId(String menuId) {
        this.menuIds.remove(menuId);
    }
}
