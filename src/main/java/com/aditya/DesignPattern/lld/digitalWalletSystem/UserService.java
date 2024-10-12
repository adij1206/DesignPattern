package com.aditya.DesignPattern.lld.digitalWalletSystem;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> userMap;

    public UserService() {
        this.userMap = new HashMap<>();
    }

    public void addUSer(User user) {
        this.userMap.put(user.getId(), user);
    }

    public User getUserById(String id) {
        return userMap.get(id);
    }
}
