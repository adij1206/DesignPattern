package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<String, Account> accounts;

    public AccountService() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void deposit(String accountId, double amount) {
        Account account = getAccount(accountId);
        account.deposit(amount);
    }

    public void withdraw(String accountId, double amount) {
        Account account = getAccount(accountId);
        account.withdraw(amount);
    }
}
