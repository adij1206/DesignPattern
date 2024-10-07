package com.aditya.DesignPattern.lld.onlineAuctionSystem;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> users;

    public UserService() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        this.users.put(user.getId(), user);
    }

    public User getUser(String id) {
        return this.users.get(id);
    }

    public boolean validateUser(String id, String password) {
        for (User user : users.values()) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }
}
