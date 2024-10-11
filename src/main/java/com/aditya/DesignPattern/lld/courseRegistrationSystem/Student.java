package com.aditya.DesignPattern.lld.courseRegistrationSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Student {

    private String id;
    private String name;

    public Student(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
}
