package com.aditya.DesignPattern.lld.pubSubSystemV2;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Topic {

    private String name;
    private List<Message> messages;
    private Map<String, Integer> subscriberOffetMap;

    public Topic(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
        this.subscriberOffetMap = new HashMap<>();
    }

    public void subscribe(String subscriberName) {
        subscriberOffetMap.put(subscriberName, 0);
    }

    public void unsubscribe(String subscriberName) {
        subscriberOffetMap.remove(subscriberName);
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public int getCurrentOffset(String subscriberName) {
        return subscriberOffetMap.getOrDefault(subscriberName, -1);
    }

    public Message getMessageByOffSet(int offset) {
        if (offset >= messages.size()) {
            return null;
        }

        return messages.get(offset);
    }

    public void updateOffsetForSubscriber(String subscriberName, int offset) {
        subscriberOffetMap.put(subscriberName, offset);
    }
}
