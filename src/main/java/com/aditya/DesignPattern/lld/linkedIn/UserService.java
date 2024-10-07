package com.aditya.DesignPattern.lld.linkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<String, User> userMap;

    public UserService() {
        userMap = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getEmail(), user);
    }

    public User getUser(String email) {
        return userMap.get(email);
    }

    public boolean authenticateUser(String email, String password) {
        for (User user : userMap.values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public List<User> userList() {
        return new ArrayList<>(userMap.values());
    }
}
