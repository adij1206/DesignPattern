package com.aditya.DesignPattern.lld.foodDeliverySystem;

import java.util.HashMap;
import java.util.Map;

public class OrderService {

    private Map<String , Order> orderMap;

    public OrderService() {
        orderMap = new HashMap<>();
    }

    public void addOrder(Order order) {
        orderMap.put(order.getOrderId(), order);
    }

    public Order getOrderById(String orderId) {
        return orderMap.get(orderId);
    }

    public boolean assignDeliveryAgent(String orderId, String deliveryAgentId) {
        Order order = orderMap.get(orderId);

        if (OrderStatus.PREPARING.name().equals(order.getStatus())) {
            order.setDeliveryAgentId(deliveryAgentId);
            order.setStatus(OrderStatus.DELIVERY_AGENT_ASSIGNED.name());
            return true;
        }

        return false;
    }
}
