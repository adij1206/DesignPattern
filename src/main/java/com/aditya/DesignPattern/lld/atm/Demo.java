package com.aditya.DesignPattern.lld.atm;

public class Demo {

    public static void main(String[] args) {
        // Create Account
        Account account1 = new Account("12345678", 1000.0);
        Account account2 = new Account("12345679", 2000.0);

        // Create a ATM
        AccountService accountService = new AccountService();
        CashDispenser cashDispenser = new CashDispenser(10000);
        Atm atm = new Atm(accountService, cashDispenser);

        atm.addAccount(account1);
        atm.addAccount(account2);

        Card c1 = new Card("123", "1234", account1.getAccountNumber());

        atm.authenticateCard(c1);
        System.out.println(atm.checkAvailableBalance(c1.getAccountNumber()));

        atm.withdrawCash(c1.getAccountNumber(), 900);
        System.out.println(atm.checkAvailableBalance(c1.getAccountNumber()));

        atm.depositCash(account2.getAccountNumber(), 800);
        System.out.println(atm.checkAvailableBalance(account2.getAccountNumber()));

        System.out.println(atm.checkBalanceInAtm());
    }
}
