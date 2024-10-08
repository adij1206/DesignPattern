package com.aditya.DesignPattern.lld.musicStreamingService;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> userMap;

    public UserService() {
        this.userMap = new HashMap<>();
    }

    public void addUser(User user) {
        this.userMap.put(user.getId(), user);
    }

    public User getUserById(String userId) {
        return this.userMap.get(userId);
    }

    public boolean validateUser(String id, String password) {
        for (User user : userMap.values()) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }
}

