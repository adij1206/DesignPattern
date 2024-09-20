package com.aditya.DesignPattern.lld.pubSubSystem;

public class Publisher {

    String name;

    public Publisher(String name) {
        this.name = name;
    }

    public void publishMessage(String content, Topic topic) {
        Message message = new Message(content);
        topic.addMessage(message);
    }

    public void publishMessage(String content, TopicWithOffset topic) {
        Message message = new Message(content);
        topic.addMessage(message);
    }
}
