package com.aditya.DesignPattern.lld.digitalWalletSystem;

import java.util.UUID;

public abstract class PaymentMethod {

    protected String id;
    protected String userId;

    public PaymentMethod(String userId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
    }

    public abstract void processPayment(double amount, Currency currency);

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }
}
