package com.aditya.DesignPattern.lld.digitalWalletSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Transaction {

    private String id;
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private double amount;
    private Currency currency;
    private Long timestamp;
    private String paymentMethodId;

    public Transaction(String sourceAccountNumber, String destinationAccountNumber, double amount, Currency currency, String paymentMethodId) {
        this.id = UUID.randomUUID().toString();
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = System.currentTimeMillis();
        this.paymentMethodId = paymentMethodId;
    }
}
