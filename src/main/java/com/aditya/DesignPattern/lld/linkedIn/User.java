package com.aditya.DesignPattern.lld.linkedIn;

import lombok.Data;

@Data
public class User {

    private String email;
    private String name;
    private String password;

    public User(String id, String name, String password) {
        this.email = id;
        this.name = name;
        this.password = password;
    }


}
