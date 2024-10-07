package com.aditya.DesignPattern.lld.linkedIn;

import java.util.HashMap;
import java.util.Map;

public class ProfileService {

    private Map<String, Profile> profileMap;

    public ProfileService() {
        profileMap = new HashMap<>();
    }

    public void addProfile(String userId) {
        Profile profile = new Profile(userId);
        this.profileMap.put(profile.getUserId(), profile);
    }

    public Profile getProfile(String userId) {
        return this.profileMap.get(userId);
    }

    public void updateProfilePicture(String userId, String picture) {
        Profile profile = this.profileMap.get(userId);
        profile.setProfilePicture(picture);
    }
}
