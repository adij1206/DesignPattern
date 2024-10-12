package com.aditya.DesignPattern.lld.foodDeliverySystem;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Order {

    private String orderId;
    private String restaurantId;
    private String customerId;
    private Long orderDate;
    private List<OrderItem> orderItems;
    private double totalAmount;
    private String status;
    private String deliveryAgentId;

    public Order(String restaurantId, List<OrderItem> orderItems, double totalAmount, String customerId) {
        this.orderId = UUID.randomUUID().toString();
        this.restaurantId = restaurantId;
        this.orderDate = System.currentTimeMillis();
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.status = OrderStatus.CREATED.name();
        this.customerId = customerId;
    }
}
