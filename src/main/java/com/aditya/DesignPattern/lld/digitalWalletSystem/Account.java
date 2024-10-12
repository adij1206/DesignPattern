package com.aditya.DesignPattern.lld.digitalWalletSystem;

import lombok.Data;

@Data
public class Account {

    private String accountNumber;
    private String userId;
    private double balance;
    private Currency currency;

    public Account(String accountNumber, String userId, double balance, Currency currency) {
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.balance = balance;
        this.currency = currency;
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) {
        if (balance<amount) {
            System.out.println("Insufficient funds");
            return;
        }

        balance-=amount;
    }
}
