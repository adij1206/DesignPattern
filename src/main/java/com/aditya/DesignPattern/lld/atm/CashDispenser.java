package com.aditya.DesignPattern.lld.atm;

public class CashDispenser {

    private double availableCash;

    public CashDispenser(double availableCash) {
        this.availableCash = availableCash;
    }

    public double getAvailableCash() {
        return availableCash;
    }

    public synchronized void dispenseCash(double amount) {
        if (availableCash<amount) {
            throw new RuntimeException("Cannot dispense the amount of " + amount + " cash");
        }

        availableCash -= amount;
        System.out.println("Dispensed " + amount + " cash");
    }

    public synchronized void depoitCash(double amount) {
        availableCash += amount;
        System.out.println("Deposited " + amount + " cash");
    }
}
