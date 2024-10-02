package com.aditya.DesignPattern.lld.oms;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> userList;

    public UserService() {
        this.userList = new HashMap<>();
    }

    public void addUser(User user) {
        this.userList.put(user.getUserId(), user);
    }

    public User getUserByUserId(String userId) {
        return this.userList.get(userId);
    }

    public Boolean validateUser(String userId) {
        User user = userList.get(userId);

        if (user!=null) {
            return true;
        }

        return false;
    }

}
