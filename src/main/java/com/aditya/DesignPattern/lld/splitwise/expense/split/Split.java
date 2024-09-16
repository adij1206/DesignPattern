package com.aditya.DesignPattern.lld.splitwise.expense.split;

import com.aditya.DesignPattern.lld.splitwise.user.User;

import java.math.BigDecimal;

public class Split {

    private BigDecimal amount;
    private User user;

    public Split(BigDecimal amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
