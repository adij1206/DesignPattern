package com.aditya.DesignPattern.lld.SurveySystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Question {

    private String questionId;
    private String questionText;
    private String surveyId;

    public Question(String questionText, String surveyId) {
        this.questionId = UUID.randomUUID().toString();
        this.questionText = questionText;
        this.surveyId = surveyId;
    }
}
