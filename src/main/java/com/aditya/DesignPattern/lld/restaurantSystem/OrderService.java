package com.aditya.DesignPattern.lld.restaurantSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private Map<String, Order> orderMap;
    private Map<String, OrderItem> orderItemMap;

    public OrderService() {
        orderMap = new HashMap<>();
        orderItemMap = new HashMap<>();
    }

    public void addOrder(Order order) {
        this.orderMap.put(order.getOrderId(), order);
    }

    public Order getOrder(String orderId) {
        return this.orderMap.get(orderId);
    }

    public void updateOrderStatus(String orderId, OrderStatus orderStatus) {
        Order order = this.orderMap.get(orderId);
        order.setStatus(orderStatus.name());
    }

    public void updateTotalPrice(String orderId, Double totalPrice) {
        Order order = this.orderMap.get(orderId);
        order.setTotalPrice(totalPrice);
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItemMap.put(orderItem.getId(), orderItem);
    }

    public OrderItem getOrderItem(String orderItemId) {
        return this.orderItemMap.get(orderItemId);
    }

    public List<OrderItem> getOrderItemsByOrderId(String orderId) {
        List<OrderItem> orderItemList = new ArrayList<>();

        for (OrderItem orderItem : this.orderItemMap.values()) {
            if (orderItem.getOrderId().equals(orderId)) {
                orderItemList.add(orderItem);
            }
        }

        return orderItemList;
    }

    public void updateServedStatusOdOrderItem(String orderItemId, Boolean isServed) {
        OrderItem orderItem = this.orderItemMap.get(orderItemId);
        orderItem.setIsServed(isServed);
    }

    public void addAddOnItemIds(String orderItemId, List<String> addOnItemIds) {
        OrderItem orderItem = this.orderItemMap.get(orderItemId);

        if (orderItem.getAddOnItemIds() != null) {
            orderItem.getAddOnItemIds().addAll(addOnItemIds);
        } else {
            orderItem.setAddOnItemIds(addOnItemIds);
        }
    }
}
