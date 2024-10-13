package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LikeAndCommentService {

    private Map<String, Like> likeMap;
    private Map<String, Comment> commentMap;

    public LikeAndCommentService() {
        likeMap = new HashMap<>();
        commentMap = new HashMap<>();
    }

    public void addLike(Like like) {
        likeMap.put(like.getId(), like);
    }

    public void addComment(Comment comment) {
        commentMap.put(comment.getId(), comment);
    }

    public Comment getCommentById(String id) {
        return commentMap.get(id);
    }

    public List<Like> getLikeListByPostId(String postId) {
        List<Like> likeList = new ArrayList<>();

        for (Like like : likeMap.values()) {
            if (like.getPostId().equals(postId)) {
                likeList.add(like);
            }
        }

        return likeList;
    }

    public List<Comment> getCommentListByPostId(String postId) {
        List<Comment> commentList = new ArrayList<>();

        for (Comment comment : commentMap.values()) {
            if (comment.getPostId().equals(postId)) {
                commentList.add(comment);
            }
        }

        return commentList;
    }
}
