package com.aditya.DesignPattern.lld.pubSubSystem.pushBased;

public class Message {

    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
