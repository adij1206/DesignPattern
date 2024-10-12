package com.aditya.DesignPattern.lld.digitalWalletSystem;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<String, Account> accountMap;

    public AccountService() {
        this.accountMap = new HashMap<>();
    }

    public void addAccount(Account account) {
        this.accountMap.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return this.accountMap.get(accountNumber);
    }

    public void credit(String accountNumber, double amount) {
        Account account = accountMap.get(accountNumber);
        account.credit(amount);
    }

    public void debit(String accountNumber, double amount) {
        Account account = accountMap.get(accountNumber);
        account.debit(amount);
    }
}
