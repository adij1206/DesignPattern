package com.aditya.DesignPattern.lld.onlineShoppingSystem;

import lombok.Data;

@Data
public class OrderItem {

    private String productId;
    private int quantity;

    public OrderItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
