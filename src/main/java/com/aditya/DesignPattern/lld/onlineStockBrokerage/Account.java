package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import lombok.Data;

import java.util.UUID;

@Data
public class Account {

    private String accountId;
    private String userId;
    private String portfolioId;
    private double balance;

    public Account(String userId, double balance) {
        this.accountId = UUID.randomUUID().toString();
        this.userId = userId;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("User Cannot withdraw Money!");
            return;
        }

        balance -= amount;
    }
}
