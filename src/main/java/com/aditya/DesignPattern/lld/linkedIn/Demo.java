package com.aditya.DesignPattern.lld.linkedIn;

public class Demo {

    public static void main(String[] args) {
        User user1 = new User("adb@gmail.com", "Aditya", "1234");
        User user2 = new User("adc@gmail.com", "Adi", "1235");

        JobPosting jobPosting = new JobPosting("Software Developer", "2");

        LinkedInService linkedInService = LinkedInService.getInstance();

        linkedInService.addUser(user1);
        linkedInService.addUser(user2);

        linkedInService.authenticateUser("adb@gmail.com", "1234");
        linkedInService.authenticateUser("adc@gmail.com", "1235");

        Connection connection = linkedInService.sendConnectionRequest(user1.getEmail(), user2.getEmail());

        System.out.println(linkedInService.getAllUnacceptedConnectionsOfReceiver(user2.getEmail()));
        linkedInService.acceptConnectionRequest(connection.getConnectionId());

        linkedInService.sendMessage(user2.getEmail(), user1.getEmail(), "hi");

        System.out.println(linkedInService.getChatMessages(user1.getEmail(), user2.getEmail()));

        linkedInService.postJob(jobPosting);

        System.out.println(linkedInService.getNotificationForUser(user1.getEmail()));

        System.out.println(linkedInService.getNotificationForUser(user2.getEmail()));

    }
}
