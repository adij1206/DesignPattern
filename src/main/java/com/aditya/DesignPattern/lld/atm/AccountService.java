package com.aditya.DesignPattern.lld.atm;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<String, Account> accounts;

    public AccountService() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        this.accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return this.accounts.get(accountNumber);
    }

   public void processTransaction(Transaction transaction) {
        transaction.execute();
   }
}
