package com.aditya.DesignPattern.lld.atm;

import java.util.UUID;

public class Atm {

    private AccountService accountService;
    private CashDispenser cashDispenser;

    public Atm(AccountService accountService, CashDispenser cashDispenser) {
        this.accountService = accountService;
        this.cashDispenser = cashDispenser;
    }

    public boolean authenticateCard(Card card) {
        // Authenticate Logic

        return true;
    }

    public double checkAvailableBalance(String accountNumber) {
        Account account = accountService.getAccount(accountNumber);
        return account.getBalance();
    }

    public void addAccount(Account account) {
        accountService.addAccount(account);
    }

    public Transaction withdrawCash(String accountNumber, double amount) {
        Account account = accountService.getAccount(accountNumber);
        Transaction transaction = new WithdrawTransaction(UUID.randomUUID().toString(), account, amount);
        cashDispenser.dispenseCash(amount);
        return transaction;
    }

    public Transaction depositCash(String accountNumber, double amount) {
        Account account = accountService.getAccount(accountNumber);
        Transaction transaction = new DepositTransaction(UUID.randomUUID().toString(), account, amount);
        cashDispenser.depoitCash(amount);
        return transaction;
    }

    public double checkBalanceInAtm() {
        return cashDispenser.getAvailableCash();
    }
}
