package com.aditya.DesignPattern.lld.linkedIn;

import lombok.Data;

import java.util.UUID;

@Data
public class Notification {

    private String notificationId;
    private String userId;
    private String content;
    private String type;

    public Notification(String userId, String content, String type) {
        this.notificationId = UUID.randomUUID().toString();
        this.userId = userId;
        this.content = content;
        this.type = type;
    }
}
