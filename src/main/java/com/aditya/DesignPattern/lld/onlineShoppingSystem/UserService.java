package com.aditya.DesignPattern.lld.onlineShoppingSystem;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        this.users.put(user.getUserId(), user);
    }

    public User getUSerById(String userId) {
        return this.users.get(userId);
    }
}
