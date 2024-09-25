package com.aditya.DesignPattern.lld.vendingMachine.v2;

public class Product {

    private int code;
    private int price;
    private int quantity;

    public Product(int code, int price, int quantity) {
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
