package com.aditya.DesignPattern.lld.SurveySystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Survey {

    private String surveyId;
    private String userId;
    private String surveyName;
    private Long createdTimeStamp;

    public Survey(String userId, String surveyName) {
        this.surveyId = UUID.randomUUID().toString();
        this.userId = userId;
        this.surveyName = surveyName;
        this.createdTimeStamp = System.currentTimeMillis();
    }
}
