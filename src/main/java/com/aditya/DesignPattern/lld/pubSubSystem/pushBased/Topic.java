package com.aditya.DesignPattern.lld.pubSubSystem.pushBased;

import java.util.LinkedList;
import java.util.Queue;

public class Topic {

    private String topicName;
    private Queue<Message> messageQueue;

    public Topic (String topicName) {
        this.topicName = topicName;
        messageQueue = new LinkedList<>();
    }

    public String getTopicName() {
        return topicName;
    }

    public void addMessage(Message message) {
        messageQueue.add(message);
    }

}
