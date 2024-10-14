package com.aditya.DesignPattern.lld.pubSubSystemV2;

import lombok.Data;

@Data
public class Publisher {

    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public void publishMessage(Topic topic, String content) {
        Message message = new Message(content);
        topic.addMessage(message);
    }
}
