package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Friend {

    private String id;
    private String userId1;
    private String userId2;

    public Friend(String userId1, String userId2) {
        this.id = UUID.randomUUID().toString();
        this.userId1 = userId1;
        this.userId2 = userId2;
    }
}
