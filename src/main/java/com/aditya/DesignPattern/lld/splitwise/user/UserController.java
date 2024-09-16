package com.aditya.DesignPattern.lld.splitwise.user;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public void add(User user) {
        users.add(user);
    }

    public User getUser(String userId) {
        for (User user : users) {
            if(user.getUserId().equals(userId)) {
                return user;
            }
        }

        return null;
    }

    public void addAllUsers(List<User> users) {
        this.users.addAll(users);
    }

    public List<User> getUsers() {
        return this.users;
    }
}
