package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Like {

    private String id;
    private String userId;
    private String postId;

    public Like(String userId, String postId) {
        this.userId = userId;
        this.postId = postId;
        this.id = UUID.randomUUID().toString();
    }
}
