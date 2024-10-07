package com.aditya.DesignPattern.lld.linkedIn;

import lombok.Data;

import java.util.UUID;

@Data
public class JobPosting {

    private String jobId;
    private String jobtitle;
    private String yearOfExperience;

    public JobPosting(String jobtitle, String yearOfExperience) {
        this.jobId = UUID.randomUUID().toString();
        this.jobtitle = jobtitle;
        this.yearOfExperience = yearOfExperience;
    }
}
