package com.aditya.DesignPattern.lld.loggingFramework;

import lombok.Data;

import java.util.UUID;

@Data
public class LogContent {

    private String id;
    private String content;
    private int logLevel;
    private Long createdTimestamp;

    public LogContent(String content, int logLevel) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.logLevel = logLevel;
        this.createdTimestamp = System.currentTimeMillis();
    }
}
