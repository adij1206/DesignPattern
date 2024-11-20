package com.aditya.DesignPattern.lld.restaurantSystem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class OrderItem {

    private String id;
    private String orderId;
    private String menuItemId;
    private Boolean isServed;
    private List<String> addOnItemIds;

    public OrderItem(String orderId, String menuItemId) {
        this.id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.menuItemId = menuItemId;
        this.isServed = false;
        this.addOnItemIds = new ArrayList<>();
    }
}
