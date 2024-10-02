package com.aditya.DesignPattern.lld.oms;

public class Wallet {

    private String walletId;
    private double amount;

    public Wallet(String walletId, double amount) {
        this.walletId = walletId;
        this.amount = amount;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
