package com.aditya.DesignPattern.lld.linkedIn;

import lombok.Data;

import java.util.UUID;

@Data
public class Message {

    private String messageId;
    private String senderUserId;
    private String receiverUserId;
    private String content;

    public Message(String senderUserId, String receiverUserId, String content) {
        this.messageId = UUID.randomUUID().toString();
        this.senderUserId = senderUserId;
        this.receiverUserId = receiverUserId;
        this.content = content;
    }
}
