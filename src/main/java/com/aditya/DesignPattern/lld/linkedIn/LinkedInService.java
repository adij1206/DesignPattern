package com.aditya.DesignPattern.lld.linkedIn;

import java.util.List;

public class LinkedInService {

    private static LinkedInService instance;
    private UserService userService;
    private JobPostingService jobPostingService;
    private ProfileService profileService;
    private ConnectionService connectionService;
    private NotificationService notificationService;
    private MessageService messageService;

    private LinkedInService() {
        userService = new UserService();
        jobPostingService = new JobPostingService();
        profileService = new ProfileService();
        connectionService = new ConnectionService();
        notificationService = new NotificationService();
        messageService = new MessageService();
    }

    public synchronized static LinkedInService getInstance() {
        if (instance == null) {
            instance = new LinkedInService();
        }

        return instance;
    }

    public void addUser(User user) {
        profileService.addProfile(user.getEmail());
        userService.addUser(user);
    }

    public void authenticateUser(String email, String password) {
        boolean isValidUser = userService.authenticateUser(email, password);

        if (!isValidUser) {
            System.out.println("Not Authenticated");
        }
    }

    public List<User> getAllUser() {
        return userService.userList();
    }

    public Connection sendConnectionRequest(String senderUserId, String receiverUserId) {
        sendNotification(receiverUserId, "Received Connection Request!", NotificationType.CONNECTION_REQUEST);
        return connectionService.addConnection(senderUserId, receiverUserId);
    }

    public List<Connection> getAllUnacceptedConnectionsOfReceiver(String userId) {
        return connectionService.getAllUnacceptedConnectionsOfReceiver(userId);
    }

    public void acceptConnectionRequest(String connectionId) {
        connectionService.acceptConnection(connectionId);
    }

    public void sendMessage(String senderUserId, String receiverUserId, String message) {
        messageService.addMessage(senderUserId, receiverUserId, message);
        sendNotification(receiverUserId, "Received New Message!", NotificationType.MESSAGE);
    }

    public List<Message> getChatMessages(String senderUserId, String receiverUserId) {
        return messageService.getChatForAUser(senderUserId, receiverUserId);
    }

    public void postJob(JobPosting jobPosting) {
        jobPostingService.addJobPosting(jobPosting);
        List<User> users = userService.userList();
        publishToAllUser(users);
    }

    private void publishToAllUser(List<User> users) {
        for (User user : users) {
            sendNotification(user.getEmail(), "Published to all users", NotificationType.JOB_POSTING);
        }
    }

    public JobPosting getJobPosting(String jobPostingId) {
        return jobPostingService.getJobPostingById(jobPostingId);
    }

    public void updateProfilePicture(String profilePictureUrl, String userId) {
        profileService.updateProfilePicture(userId, profilePictureUrl);
    }

    private void sendNotification(String userId, String message, NotificationType notificationType) {
        Notification notification = new Notification(userId, message, notificationType.name());
        notificationService.addNotification(notification);
    }

    public List<Notification> getNotificationForUser(String userId) {
        return notificationService.getNotificationListByUserId(userId);
    }
}
