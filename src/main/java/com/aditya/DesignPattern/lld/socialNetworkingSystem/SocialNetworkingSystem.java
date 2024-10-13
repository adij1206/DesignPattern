package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import java.util.ArrayList;
import java.util.List;

public class SocialNetworkingSystem {

    private static SocialNetworkingSystem instance;

    private UserService userService;
    private FriendService friendService;
    private FriendRequestService friendRequestService;
    private PostService postService;
    private LikeAndCommentService likeAndCommentService;

    private SocialNetworkingSystem() {
        this.userService = new UserService();
        this.friendService = new FriendService();
        this.friendRequestService = new FriendRequestService();
        this.postService = new PostService();
        this.likeAndCommentService = new LikeAndCommentService();
    }

    public static SocialNetworkingSystem getInstance() {
        if (instance == null) {
            instance = new SocialNetworkingSystem();
        }

        return instance;
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    public void updateProfilePicture(String email, String profilePicture) {
        userService.updateProfilePicture(email, profilePicture);
        System.out.println("Profile Picture Updated");
    }


    public void updateDescription(String email, String description) {
        userService.updateDescription(email, description);
        System.out.println("Description Updated");
    }

    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    public boolean validateUser(String email, String password) {
        return userService.validateUser(email, password);
    }

    public FriendRequest sendFriendRequest(String senderUserId, String receiverUSerId) {
        FriendRequest friendRequest = new FriendRequest(senderUserId, receiverUSerId);
        friendRequestService.addFriendRequest(friendRequest);
        return friendRequest;
    }

    public List<FriendRequest> getAllPendingFriendRequestOfUser(String userId) {
        return friendRequestService.getAllPendingFriendRequestOfUser(userId);
    }

    public void acceptFriendRequest(String friendRequestId) {
        FriendRequest friendRequest = friendRequestService.updateFriendRequestStatus(
                friendRequestId, FriendRequestStatus.ACCEPTED);

        Friend friend = new Friend(friendRequest.getReceiverUserId(), friendRequest.getSenderUserId());
        friendService.addFriend(friend);
        System.out.println("Friend Request Accepted");
    }

    public void rejectFriendRequest(String friendRequestId) {
        friendRequestService.updateFriendRequestStatus(
                friendRequestId, FriendRequestStatus.REJECTED);
        System.out.println("Friend Request rejected");
    }

    public List<Friend> getFriends(String userId) {
        return friendService.getFriends(userId);
    }

    public void addPost(Post post) {
        postService.addPost(post);
    }


    public List<Post> getNewsFeedForUser(String userId) {
        List<Friend> friends = friendService.getFriends(userId);

        List<String> userIds = new ArrayList<>();
        for (Friend friend : friends) {
            if (friend.getUserId2().equals(userId)) {
                userIds.add(friend.getUserId1());
            } else {
                userIds.add(friend.getUserId2());
            }
        }
        userIds.add(userId);

        return postService.getAllPost(userIds);
    }

    public List<Post> getAllPostOfUser(String userId) {
        return postService.getAllPostOfUser(userId);
    }

    public void addLike(String postId, String userId) {
        Like like = new Like(userId, postId);
        likeAndCommentService.addLike(like);
    }

    public void addComment(String postId, String userId, String comment) {
        Comment comment1 = new Comment(userId, comment, postId);
        likeAndCommentService.addComment(comment1);
    }

    public List<Comment> getAllCommentsOfPost(String postId) {
        return likeAndCommentService.getCommentListByPostId(postId);
    }

    public List<Like> getLikeListByPostId(String postId) {
        return likeAndCommentService.getLikeListByPostId(postId);
    }
}
