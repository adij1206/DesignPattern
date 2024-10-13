package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import lombok.Data;

@Data
public class User {

    private String email;
    private String password;
    private String description;
    private String profilePicture;
    private String name;

    public User(String email, String password, String name, String description, String profilePicture) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.description = description;
        this.profilePicture = profilePicture;
    }
}
