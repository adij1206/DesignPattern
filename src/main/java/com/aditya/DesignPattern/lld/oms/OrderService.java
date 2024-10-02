package com.aditya.DesignPattern.lld.oms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private Map<String , Order> orders;

    public OrderService() {
        this.orders = new HashMap<>();
    }

    public Order createOrder(String orderId, String userId, List<String> vehicleId, double amount) {
        Order order = new Order(orderId, vehicleId, userId, amount);
        orders.put(order.getOrderId(), order);

        return order;
    }

    public Order getOrderByOrderId(String orderId) {
        return orders.get(orderId);
    }

    public void updateOrderStatus(String orderId, String status) {
        Order order = orders.get(orderId);
        order.setStatus(status);
    }


}
