package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostService {

    private Map<String, Post> postMap;

    public PostService() {
        this.postMap = new HashMap<>();
    }

    public void addPost(Post post) {
        postMap.put(post.getId(), post);
    }

    public Post getPostById(String id) {
        return postMap.get(id);
    }

    public List<Post> getAllPost(List<String> userIds) {
        List<Post> posts = new ArrayList<>();

        for (Post post : postMap.values()) {
            if (userIds.contains(post.getUserId())) {
                posts.add(post);
            }
        }

        return posts;
    }

    public List<Post> getAllPostOfUser(String userId) {
        List<Post> posts = new ArrayList<>();

        for (Post post : postMap.values()) {
            if (post.getUserId().equals(userId)) {
                posts.add(post);
            }
        }

        return posts;
    }
}
