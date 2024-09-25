package com.aditya.DesignPattern.lld.vendingMachine;

import java.math.BigDecimal;

public class Product {

    private String id;
    private BigDecimal price;
    private int quantity;

    public Product(String id, BigDecimal price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getId() {
        return this.id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void subtractQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
