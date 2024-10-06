package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public String getAccountIdByUserId(String userId) {
        return users.get(userId).getAccountId();
    }

    public void setAccountNumber(String userId, String accountId) {
        users.get(userId).setAccountId(accountId);
    }
}
