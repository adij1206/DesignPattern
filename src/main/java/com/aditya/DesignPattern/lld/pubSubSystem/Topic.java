package com.aditya.DesignPattern.lld.pubSubSystem;

import java.util.LinkedList;
import java.util.Queue;

public class Topic {

    private String name;
    private Queue<Message> messageQueue;

    public Topic(String name) {
        this.name = name;
        this.messageQueue = new LinkedList<>();
    }

    public void addMessage(Message message) {
        messageQueue.add(message);
    }

    public boolean hasNext() {
        return !messageQueue.isEmpty();
    }

    public Message next() {
        if (!messageQueue.isEmpty()) {
            return messageQueue.remove();
        }

        return null;
    }
}
