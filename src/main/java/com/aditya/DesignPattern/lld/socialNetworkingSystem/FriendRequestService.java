package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendRequestService {

    private Map<String, FriendRequest> friendRequests;

    public FriendRequestService() {
        this.friendRequests = new HashMap<>();
    }

    public void addFriendRequest(FriendRequest friendRequest) {
        friendRequests.put(friendRequest.getId(), friendRequest);
    }

    public FriendRequest getFriendRequest(String friendRequestId) {
        return friendRequests.get(friendRequestId);
    }

    public List<FriendRequest> getAllPendingFriendRequestOfUser(String userId) {
        List<FriendRequest> pendingFriendRequests = new ArrayList<>();

        for (FriendRequest friendRequest : friendRequests.values()) {
            if (friendRequest.getReceiverUserId().equals(userId) && FriendRequestStatus.PENDING.equals(
                    friendRequest.getStatus())) {
                pendingFriendRequests.add(friendRequest);
            }
        }

        return pendingFriendRequests;
    }

    public FriendRequest updateFriendRequestStatus(String friendRequestId, FriendRequestStatus newStatus) {
        FriendRequest friendRequest = friendRequests.get(friendRequestId);
        friendRequest.setStatus(newStatus);

        return friendRequest;
    }
}
