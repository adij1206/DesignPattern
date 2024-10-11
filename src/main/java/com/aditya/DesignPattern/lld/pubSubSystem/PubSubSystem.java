package com.aditya.DesignPattern.lld.pubSubSystem;

import java.util.Arrays;

public class PubSubSystem {

    public static void main(String[] args) throws InterruptedException {
        // Broker Responsible to maintaining the topics
        Broker broker = new Broker();

//        Topic emailNotification = broker.createTopic("EmailNotification");
//        Topic textNotification = broker.createTopic("TextNotification");
//
        // Publisher will publish the message in the topics
        Publisher emailNotificationPublisher = new Publisher("EmailNotification");
        Publisher textNotificationPublisher = new Publisher("TextNotification");

        // Subscriber will subscribe to topics and Pull the message continuously
        Subscriber emailTextSubscriber = new Subscriber("EmailTextSubscriber");
        Subscriber textSubscriber = new Subscriber("TextSubscriber");
//
//
//        emailTextSubscriber.subscribe(emailNotification);
//        //emailTextSubscriber.subscribe(textNotification); // Ideally this cannot happen has one subscribe can listen to one topic but topic can be subscribed by multiple subscriber
//
//        textSubscriber.subscribe(textNotification);
//
//        emailNotificationPublisher.publishMessage("Send Email!", emailNotification);
//        textNotificationPublisher.publishMessage("Send Text!", textNotification);


        // Creating Topics And Subscriber with Offset support
        TopicWithOffset emailNotificationWithOffset = broker.createTopicWithOffset("EmailNotificationWithOffset");
        TopicWithOffset textNotificationWithOffset = broker.createTopicWithOffset("TextNotificationWithOffset");

        //        emailTextSubscriber.subscribeWithOffset(emailNotificationWithOffset);
        //        emailTextSubscriber.subscribeWithOffset(textNotificationWithOffset);
        //
        //        textSubscriber.subscribeWithOffset(textNotificationWithOffset);

        //        emailNotificationPublisher.publishMessage("Send Email with Offset!", emailNotificationWithOffset);
        //        textNotificationPublisher.publishMessage("Send Text with Offset!", textNotificationWithOffset);

        emailTextSubscriber.subscribeWithOffset(broker, emailNotificationWithOffset.getName());
        emailTextSubscriber.subscribeWithOffset(broker, textNotificationWithOffset.getName());
        textSubscriber.subscribeWithOffset(broker, textNotificationWithOffset.getName());

        emailNotificationPublisher.publishMessage(broker, emailNotificationWithOffset.getName(), "Send Email!");
        textNotificationPublisher.publishMessage(broker, textNotificationWithOffset.getName(), "Send Text!");


        Thread.sleep(1000);
        emailTextSubscriber.unsubscribe(textNotificationWithOffset.getName());

        emailNotificationPublisher.publishMessage(broker, emailNotificationWithOffset.getName(), "Send Email!");
        textNotificationPublisher.publishMessage(broker, textNotificationWithOffset.getName(), "Send Text!");
    }
}
