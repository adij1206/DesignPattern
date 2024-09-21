package com.aditya.DesignPattern.lld.pubSubSystem.pushBased;

public class Publisher {

    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public void publishMessage(String content, String topicName, Broker broker) {
        Message message = new Message(content);
        broker.publish(message, topicName);
    }
}
