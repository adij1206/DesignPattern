package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendService {

    private Map<String, Friend> friendMap;

    public FriendService() {
        this.friendMap = new HashMap<>();
    }

    public void addFriend(Friend friend) {
        this.friendMap.put(friend.getId(), friend);
    }

    public boolean checkIfFriend(String userId1, String userId2) {
        for (Friend friend : this.friendMap.values()) {
            return (friend.getUserId1().equals(userId1) && friend.getUserId2().equals(userId2)) ||
                    friend.getUserId1().equals(userId2) && friend.getUserId2().equals(userId1);
        }

        return false;
    }

    public List<Friend> getFriends(String userId) {
        List<Friend> friends = new ArrayList<>();

        for (Friend friend : friendMap.values()) {
            if (friend.getUserId1().equals(userId) || friend.getUserId2().equals(userId)) {
                friends.add(friend);
            }
        }

        return friends;
    }
}
