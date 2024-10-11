package com.aditya.DesignPattern.lld.googleDrive;

import lombok.Data;

@Data
public class VersionHistory {

    private User user;
    private String content;
    private Long createdTimeStamp;

    public VersionHistory(User user, String content) {
        this.user = user;
        this.content = content;
        this.createdTimeStamp = System.currentTimeMillis();
    }
}
