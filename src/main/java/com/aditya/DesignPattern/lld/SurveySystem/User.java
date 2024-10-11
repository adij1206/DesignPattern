package com.aditya.DesignPattern.lld.SurveySystem;

import lombok.Data;

@Data
public class User {

    private String email;
    private String password;
    private String name;
    private Role role;

    public User(String email, String password, String name, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }
}
