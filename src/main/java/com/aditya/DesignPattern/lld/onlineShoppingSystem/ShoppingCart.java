package com.aditya.DesignPattern.lld.onlineShoppingSystem;

import lombok.Data;

import java.util.*;

@Data
public class ShoppingCart {

    private String shoppingCartId;
    private String userId;
    private Map<String, OrderItem> items;
    private double price;

    public ShoppingCart(String userId) {
        this.shoppingCartId = UUID.randomUUID().toString();
        this.items = new HashMap<>();
        this.userId = userId;
        this.price = 0.0;
    }

    public void addOrderItem(OrderItem orderItem, double price) {
        this.items.put(orderItem.getProductId(), orderItem);
        this.price += price;
    }

    public OrderItem getOrderItem(String productId) {
        return this.items.get(productId);
    }

    public List<OrderItem> getAllOrderItem() {
        return new ArrayList<>(this.items.values());
    }

    public void removeProduct(String productId, int quantity) {
        OrderItem orderItem = items.get(productId);

        if (quantity == orderItem.getQuantity()) {
            items.remove(productId);
        } else {
            orderItem.setQuantity(orderItem.getQuantity() - quantity);
        }
    }
}
