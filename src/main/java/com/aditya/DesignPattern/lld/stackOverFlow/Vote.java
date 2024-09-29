package com.aditya.DesignPattern.lld.stackOverFlow;

public class Vote {

    private int value;
    private User user;

    public Vote (int value, User user ) {
        this.user = user;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public User getUser() {
        return user;
    }
}
