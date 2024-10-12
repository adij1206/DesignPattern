package com.aditya.DesignPattern.lld.digitalWalletSystem;

public class CreditCard extends PaymentMethod{

    private String creditCardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCard(String userId, String creditCardNumber, String expiryDate, String cvv) {
        super(userId);
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void processPayment(double amount, Currency currency) {
        System.out.println("Processing Credit Card Payment");
    }
}
