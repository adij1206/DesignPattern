package com.aditya.DesignPattern.lld.linkedIn;

import lombok.Data;

import java.util.UUID;

@Data
public class Connection {

    private String connectionId;
    private String senderUserId;
    private String receiverUserId;
    private boolean accepted;

    public Connection(String senderUserId, String receiverUserId) {
        this.connectionId = UUID.randomUUID().toString();
        this.senderUserId = senderUserId;
        this.receiverUserId = receiverUserId;
        this.accepted = false;
    }
}
