package com.aditya.DesignPattern.lld.onlineShoppingSystem;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartService {

    private Map<String, ShoppingCart> shoppingCarts;

    public ShoppingCartService() {
        this.shoppingCarts = new HashMap<>();
    }

    public void addItemInCart(String userId, OrderItem orderItem, double price) {
        ShoppingCart shoppingCart = shoppingCarts.getOrDefault(userId, new ShoppingCart(userId));
        shoppingCart.addOrderItem(orderItem, price);
        shoppingCarts.put(userId, shoppingCart);
    }

    public void removeItemFromCart(String userId, String productId, int quantity) {
        ShoppingCart shoppingCart = shoppingCarts.get(userId);
        shoppingCart.removeProduct(productId, quantity);
    }

    public ShoppingCart getShoppingCart(String userId) {
        return shoppingCarts.get(userId);
    }

    public double getTotalPriceOfCart(String userId) {
        ShoppingCart shoppingCart = getShoppingCart(userId);
        return shoppingCart.getPrice();
    }

    public void removeShoppingCart(String userId) {
        shoppingCarts.remove(userId);
    }
}
