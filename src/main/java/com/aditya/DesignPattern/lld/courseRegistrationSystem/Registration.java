package com.aditya.DesignPattern.lld.courseRegistrationSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Registration {

    private String registrationId;
    private String studentId;
    private String courseId;
    private Long createdTimestamp;

    public Registration(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.createdTimestamp = System.currentTimeMillis();
        this.registrationId = UUID.randomUUID().toString();
    }
}
