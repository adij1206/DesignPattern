package com.aditya.DesignPattern.lld.onlineShoppingSystem;

import java.util.HashMap;
import java.util.Map;

public class OrderService {

    private Map<String, Order> orderMap;

    public OrderService() {
        orderMap = new HashMap<>();
    }

    public void addOrder(Order order) {
        this.orderMap.put(order.getOrderId(), order);
    }

    public Order getOrder(String orderId) {
        return this.orderMap.get(orderId);
    }

    public void updateStatus(String orderId, OrderStatus orderStatus) {
        Order order = this.orderMap.get(orderId);
        order.updateStatus(orderStatus);
    }
}
