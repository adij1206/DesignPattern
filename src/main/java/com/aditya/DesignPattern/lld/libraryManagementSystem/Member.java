package com.aditya.DesignPattern.lld.libraryManagementSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Member {

    private String memberId;
    private String name;
    private int numberOfBooksBorrowed;

    public Member(String name) {
        this.memberId = UUID.randomUUID().toString();
        this.name = name;
        this.numberOfBooksBorrowed = 0;
    }
}
