package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class FriendRequest {

    private String id;
    private String senderUserId;
    private String receiverUserId;
    private FriendRequestStatus status;

    public FriendRequest(String senderUserId, String receiverUserId) {
        this.senderUserId = senderUserId;
        this.receiverUserId = receiverUserId;
        this.id = UUID.randomUUID().toString();
        this.status = FriendRequestStatus.PENDING;
    }
}
