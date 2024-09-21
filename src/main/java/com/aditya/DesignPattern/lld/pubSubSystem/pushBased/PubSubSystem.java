package com.aditya.DesignPattern.lld.pubSubSystem.pushBased;

public class PubSubSystem {

    public static void main(String[] args) throws InterruptedException {
        Broker broker = new Broker();

        Publisher emailNotificationPublisher = new Publisher("EmailNotificationPublisher");
        Publisher textNotificationPublisher = new Publisher("TextNotificationPublisher");

        broker.createTopic("EmailNotification");
        broker.createTopic("TextNotification");

        Subscriber emailNotificationSubscriber = new Subscriber("EmailNotificationSubscriber");
        Subscriber textNotificationSubscriber = new Subscriber("TextNotificationSubscriber");

        broker.subscribeToTopic("EmailNotification", emailNotificationSubscriber);
        broker.subscribeToTopic("TextNotification", textNotificationSubscriber);

        emailNotificationPublisher.publishMessage("Send Email!", "EmailNotification", broker);
        textNotificationPublisher.publishMessage("Send Text!", "TextNotification", broker);

        Thread.sleep(1000);
        emailNotificationPublisher.publishMessage("Send Email2!", "EmailNotification", broker);
    }
}
