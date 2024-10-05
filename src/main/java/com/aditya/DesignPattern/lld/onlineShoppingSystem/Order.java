package com.aditya.DesignPattern.lld.onlineShoppingSystem;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Order {

    private String orderId;
    private String userId;
    private List<OrderItem> orderItems;
    private double totalPrice;
    private String status;

    public Order(String userId, List<OrderItem> orderItems, double totalPrice) {
        this.orderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
        this.status = OrderStatus.CREATED.toString();
    }

    public void updateStatus(OrderStatus status) {
        this.status = status.toString();
    }
}
