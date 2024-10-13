package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Comment {

    private String id;
    private String comment;
    private String postId;
    private String userId;

    public Comment(String userId, String comment, String postId) {
        this.userId = userId;
        this.comment = comment;
        this.postId = postId;
        this.id = UUID.randomUUID().toString();
    }
}
