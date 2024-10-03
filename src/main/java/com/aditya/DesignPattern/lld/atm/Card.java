package com.aditya.DesignPattern.lld.atm;

import lombok.Data;

@Data
public class Card {

    private String cardNumber;
    private String pin;
    private String accountNumber;

    public Card(String cardNumber, String pin, String accountNumber) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }
}
