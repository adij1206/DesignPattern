package com.aditya.DesignPattern.lld.flightManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> userMap;

    public UserService() {
        userMap = new HashMap<>();
    }

    public void addUser(User user) {
        this.userMap.put(user.getId(), user);
    }

    public User getUSer(String id) {
        return this.userMap.get(id);
    }
}
