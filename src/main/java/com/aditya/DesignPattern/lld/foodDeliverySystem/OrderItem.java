package com.aditya.DesignPattern.lld.foodDeliverySystem;

import lombok.Data;

@Data
public class OrderItem {

    private String menuItemId;
    private int quantity;

    public OrderItem(String menuItemId, int quantity) {
        this.menuItemId = menuItemId;
        this.quantity = quantity;
    }

}
