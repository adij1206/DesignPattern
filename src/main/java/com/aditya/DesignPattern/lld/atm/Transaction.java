package com.aditya.DesignPattern.lld.atm;

public abstract class Transaction {

    protected String transactionId;
    protected Account account;
    protected double amount;

    public Transaction(String transactionId, Account account, double amount) {
        this.transactionId = transactionId;
        this.account = account;
        this.amount = amount;
    }

    public abstract void execute();
}
