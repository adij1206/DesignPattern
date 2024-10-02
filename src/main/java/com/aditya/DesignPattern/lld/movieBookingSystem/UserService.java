package com.aditya.DesignPattern.lld.movieBookingSystem;

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

    public User getUserById(String id) {
        return this.userMap.get(id);
    }
}
