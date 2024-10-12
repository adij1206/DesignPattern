package com.aditya.DesignPattern.lld.digitalWalletSystem;

public class BankTransfer extends PaymentMethod {

    private String accountNumber;
    private String routingNumber;

    public BankTransfer( String userId, String accountNumber, String routingNumber) {
        super(userId);
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    @Override
    public void processPayment(double amount, Currency currency) {
        System.out.println("Processing Bank Transfer");
    }
}
