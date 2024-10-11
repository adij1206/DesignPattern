package com.aditya.DesignPattern.lld.SurveySystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Answer {

    private String id;
    private String userId;
    private String surveyId;
    private String questionId;
    private String answerOptionId;

    public Answer(String userId, String surveyId, String questionId, String answerOptionId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.surveyId = surveyId;
        this.questionId = questionId;
        this.answerOptionId = answerOptionId;
    }
}
