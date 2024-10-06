package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import java.util.HashMap;
import java.util.Map;

public class OrderService {

    private Map<String, Order> orderMap;

    public OrderService() {
        orderMap = new HashMap<>();
    }

    public void addOrder(Order order) {
        orderMap.put(order.getOrderId(), order);
    }

    public Order getOrder(String orderId) {
        return orderMap.get(orderId);
    }

    public void updateOrder(String orderId, String status) {
        Order order = orderMap.get(orderId);
        order.setStatus(status);
    }

    public void updatePriceAndStatus(String orderId, double price, String status) {
        Order order = orderMap.get(orderId);
        order.setPrice(price);
        order.setStatus(status);
    }
}
