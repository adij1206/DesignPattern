package com.aditya.DesignPattern.pattern.structure;

import java.util.ArrayList;
import java.util.List;

abstract class Account {
    abstract int getBalance();
}

class SalaryAccount extends Account {
    private String accountNo;
    private int accountBalance;

    public SalaryAccount(String accountNo, int accountBalance) {
        this.accountBalance = accountBalance;
        this.accountNo = accountNo;
    }

    @Override
    int getBalance() {
        return accountBalance;
    }
}

class SavingAccount extends Account {
    private String accountNo;
    private int accountBalance;

    public SavingAccount(String accountNo, int accountBalance) {
        this.accountBalance = accountBalance;
        this.accountNo = accountNo;
    }

    @Override
    int getBalance() {
        return accountBalance;
    }
}

class CompositeAccount extends Account {
    private int totalBalance;
    private List<Account> accounts;

    public CompositeAccount() {
        this.totalBalance = 0;
        this.accounts = new ArrayList<>();
    }

    @Override
    int getBalance() {
        totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }

        return totalBalance;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
}

public class CompositeDesignPattern {
    public static void main(String[] args) {
        CompositeAccount compositeAccount = new CompositeAccount();

        compositeAccount.addAccount(new SalaryAccount("S11", 100));
        compositeAccount.addAccount(new SalaryAccount("S12", 150));
        compositeAccount.addAccount(new SavingAccount("A11", 200));

        int totalBalance = compositeAccount.getBalance();
        System.out.println(totalBalance);
    }
}
