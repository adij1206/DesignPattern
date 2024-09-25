package com.aditya.DesignPattern.lld.vendingMachine.v2;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private State state;
    private InventoryService inventoryService;
    private Product product;
    private int totalAmount;
    private List<Coin> coinList;

    public VendingMachine() {
        this.state = new IdleState();
        this.inventoryService = new InventoryService();
        this.coinList = new ArrayList<>();
        totalAmount = 0;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addCoin(Coin coin) {
        this.coinList.add(coin);
        this.totalAmount += coin.getAmount();
    }

    public boolean addProduct(int code) {
        if (product != null) {
            System.out.println("Already product is selected");
            return false;
        }

        if (coinList.isEmpty()) {
            return false;
        }

        Product productById = inventoryService.getProductById(code);

        if (productById.getQuantity() <= 0) {
            System.out.println("No such product");
            return false;
        }

        this.product = productById;
        return true;
    }

    public void dispenseProduct(int code) {
        inventoryService.updateQuantity(code);
        this.product = null;
        this.coinList = new ArrayList<>();
        this.totalAmount = 0;
    }

    public int refundFullMoney() {
        int amount = totalAmount;
        this.totalAmount = 0;
        this.coinList = new ArrayList<>();
        this.product = null;
        return amount;
    }

    public int returnChange() {
        if (totalAmount > product.getPrice()) {
            return totalAmount - product.getPrice();
        }

        return 0;
    }

    public void insertProduct(Product product) {
        inventoryService.addProduct(product);
    }
}
