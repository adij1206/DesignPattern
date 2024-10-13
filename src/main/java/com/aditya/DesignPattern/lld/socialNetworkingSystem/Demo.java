package com.aditya.DesignPattern.lld.socialNetworkingSystem;

import java.util.Arrays;

/**
 * <p>User Registration and Authentication:</p>
 * <p>Users should be able to create an account with their personal information, such as name, email, and password.</p>
 * <p>Users should be able to log in and log out of their accounts securely.</p>
 * <p>User Profiles:</p>
 * <p>Each user should have a profile with their information, such as profile picture, bio, and interests.</p>
 * <p>Users should be able to update their profile information.</p>
 * <p>Friend Connections:</p>
 * <p>Users should be able to send friend requests to other users.</p>
 * <p>Users should be able to accept or decline friend requests.</p>
 * <p>Users should be able to view their list of friends.</p>
 * <p>Posts and Newsfeed:</p>
 * <p>Users should be able to create posts with text, images, or videos.</p>
 * <p>Users should be able to view a newsfeed consisting of posts from their friends and their own posts.</p>
 * <p>The newsfeed should be sorted in reverse chronological order.</p>
 * <p>Likes and Comments:</p>
 * <p>Users should be able to like and comment on posts.</p>
 * <p>Users should be able to view the list of likes and comments on a post.</p>
 * <p>Privacy and Security:</p>
 * <p>Users should be able to control the visibility of their posts and profile information.</p>
 * <p>The system should enforce secure access control to ensure data privacy.</p>
 * <p>Notifications:</p>
 * <p>Users should receive notifications for events such as friend requests, likes, comments, and mentions.</p>
 * <p>Notifications should be delivered in real-time.</p>
 * <p>Scalability and Performance:</p>
 * <p>The system should be designed to handle a large number of concurrent users and high traffic load.</p>
 * <p>The system should be scalable and efficient in terms of resource utilization.</p>
 */
public class Demo {

    public static void main(String[] args) {
        User user1 = new User("abc@gmail.com", "1234", "Aditya", "Abc", "123nvb");
        User user2 = new User("abd@gmail.com", "1235", "A", "Abc", "123nvb");
        User user3 = new User("abe@gmail.com", "1236", "b", "Abc", "123nvb");
        User user4 = new User("abf@gmail.com", "1237", "C", "Abc", "123nvb");
        User user5 = new User("abg@gmail.com", "1238", "D", "Abc", "123nvb");

        SocialNetworkingSystem networkingSystem = SocialNetworkingSystem.getInstance();

        networkingSystem.addUser(user1);
        networkingSystem.addUser(user2);
        networkingSystem.addUser(user3);
        networkingSystem.addUser(user4);
        networkingSystem.addUser(user5);

        FriendRequest friendRequest1 = networkingSystem.sendFriendRequest(user1.getEmail(), user2.getEmail());
        FriendRequest friendRequest2 = networkingSystem.sendFriendRequest(user1.getEmail(), user3.getEmail());
        FriendRequest friendRequest3 = networkingSystem.sendFriendRequest(user1.getEmail(), user4.getEmail());
        FriendRequest friendRequest4 = networkingSystem.sendFriendRequest(user2.getEmail(), user4.getEmail());

        System.out.println(
                "Pending FriendRequest : " + networkingSystem.getAllPendingFriendRequestOfUser(user4.getEmail()));

        networkingSystem.acceptFriendRequest(friendRequest1.getId());
        networkingSystem.acceptFriendRequest(friendRequest2.getId());
        networkingSystem.rejectFriendRequest(friendRequest3.getId());
        networkingSystem.acceptFriendRequest(friendRequest4.getId());

        System.out.println("friend list : " + networkingSystem.getFriends(user1.getEmail()));


        Post post1 = new Post(user1.getEmail(), "Abc", Arrays.asList("abc"), Arrays.asList("Bcd"));
        networkingSystem.addPost(post1);

        Post post2 = new Post(user2.getEmail(), "Abd", Arrays.asList("abc"), Arrays.asList("Bcd"));
        networkingSystem.addPost(post2);

        Post post3 = new Post(user3.getEmail(), "Abe", Arrays.asList("abc"), Arrays.asList("Bcd"));
        networkingSystem.addPost(post3);

        Post post4 = new Post(user4.getEmail(), "Abf", Arrays.asList("abc"), Arrays.asList("Bcd"));
        networkingSystem.addPost(post4);

        System.out.println(networkingSystem.getNewsFeedForUser(user1.getEmail()));
        System.out.println(networkingSystem.getNewsFeedForUser(user2.getEmail()));

        System.out.println(networkingSystem.getNewsFeedForUser(user4.getEmail()));

        networkingSystem.addLike(post1.getId(), user2.getEmail());
        networkingSystem.addComment(post1.getId(), user2.getEmail(), "Wow");


        networkingSystem.addLike(post1.getId(), user3.getEmail());
        networkingSystem.addComment(post1.getId(), user3.getEmail(), "Wow");

        networkingSystem.addComment(post1.getId(), user2.getEmail(), "Wow");

        System.out.println(networkingSystem.getAllCommentsOfPost(post1.getId()));
        System.out.println(networkingSystem.getLikeListByPostId(post1.getId()));

    }
}
