package com.aditya.DesignPattern.lld.oms;

public class User {

    private String userId;
    private String userName;
    private String walletId;

    public User(String userId, String userName, String walletId) {
        this.userId = userId;
        this.userName = userName;
        this.walletId = walletId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }
}
