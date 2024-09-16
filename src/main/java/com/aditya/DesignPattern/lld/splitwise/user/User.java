package com.aditya.DesignPattern.lld.splitwise.user;

public class User {

    private String userId;
    private String userName;
    private UserExpenseBalanceSheet balanceSheet;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.balanceSheet = new UserExpenseBalanceSheet();
    }

    public UserExpenseBalanceSheet getBalanceSheet() {
        return this.balanceSheet;
    }

    public String getUserId() {
        return this.userId;
    }
}
