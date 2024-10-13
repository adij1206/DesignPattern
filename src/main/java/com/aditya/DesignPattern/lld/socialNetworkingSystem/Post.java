package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Post {

    private String id;
    private String userId;
    private String caption;
    private List<String> imageUrls;
    private List<String> videoUrls;

    public Post(String userId, String caption, List<String> imageUrls, List<String> videoUrls) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.caption = caption;
        this.imageUrls = imageUrls;
        this.videoUrls = videoUrls;
    }
}
