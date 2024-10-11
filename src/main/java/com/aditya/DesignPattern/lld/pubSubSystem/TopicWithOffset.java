package com.aditya.DesignPattern.lld.pubSubSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicWithOffset {

    private String name;
    private List<Message> messageList;
    private Map<Subscriber, Integer> subscriberOffsetMap;
    private Map<String, Integer> subscriptionOffsetMap;

    public TopicWithOffset(String name) {
        this.name = name;
        this.messageList = new ArrayList<>();
        this.subscriberOffsetMap = new HashMap<>();
        this.subscriptionOffsetMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addMessage(Message message) {
        messageList.add(message);
    }

    public Message getMessageByOffset(int offset) {
        if (offset>=messageList.size()) {
            return null;
        }

        return messageList.get(offset);
    }

    public int getOffset(Subscriber subscriber) {
        return subscriberOffsetMap.getOrDefault(subscriber, 0);
    }

    public void updateOffset(Subscriber subscriber, int offset) {
        subscriberOffsetMap.put(subscriber, offset);
    }

    public int getSubscriptionOffset(String subscriber) {
        return subscriptionOffsetMap.getOrDefault(subscriber, 0);
    }

    public void updateOffset(String subscriberName, int offset) {
        subscriptionOffsetMap.put(subscriberName, offset);
    }
}
