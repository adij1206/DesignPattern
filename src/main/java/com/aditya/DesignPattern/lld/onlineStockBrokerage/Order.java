package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import lombok.Data;

import java.util.UUID;

@Data
public class Order {

    private String orderId;
    private String accountId;
    private String stockId;
    private int quantity;
    private double price;
    private Long timestamp;
    private String status;

    public Order(String accountId, String stockId, int quantity, double price) {
        this.orderId = UUID.randomUUID().toString();
        this.accountId = accountId;
        this.stockId = stockId;
        this.quantity = quantity;
        this.price = price;
        this.timestamp = System.currentTimeMillis();
        this.status = OrderStatus.EXECUTED.toString();
    }
}
