package com.aditya.DesignPattern.lld.pubSubSystemV2;

import lombok.Data;

@Data
public class Message {

    private String content;

    public Message(String content) {
        this.content = content;
    }
}
