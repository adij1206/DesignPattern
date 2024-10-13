package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getEmail(), user);
    }

    public User getUserByEmail(String email) {
        return users.get(email);
    }

    public void updateProfilePicture(String email, String profilePicture) {
        User user = users.get(email);
        user.setProfilePicture(profilePicture);
    }


    public void updateDescription(String email, String description) {
        User user = users.get(email);
        user.setDescription(description);
    }

    public List<User> getAllUser() {
        return new ArrayList<>(users.values());
    }

    public boolean validateUser(String email, String password) {
        User user = users.get(email);

        if (user.getPassword().equals(password)) {
            return true;
        }

        return false;
    }
}
