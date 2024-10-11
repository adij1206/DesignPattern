package com.aditya.DesignPattern.lld.SurveySystem;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> users;

    public UserService() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getEmail(), user);
    }

    public User getUser(String email) {
        return users.get(email);
    }

    public boolean validateUser(String email, String password) {
        User user = getUser(email);

        if (user == null || !user.getPassword().equals(password)) {
            return false;
        }

        return true;
    }
}
