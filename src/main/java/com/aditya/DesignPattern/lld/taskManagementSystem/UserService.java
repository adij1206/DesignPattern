package com.aditya.DesignPattern.lld.taskManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        this.users.put(user.getEmail(), user);
    }

    public User getUserByEmail(String email) {
        return users.get(email);
    }
}
