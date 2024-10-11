package com.aditya.DesignPattern.lld.SurveySystem;

import lombok.Data;

import java.util.UUID;

@Data
public class AnswerOption {

    private String answerOptionId;
    private String answerText;
    private int score;
    private String questionId;

    public AnswerOption(String answerText, int score, String questionId) {
        this.answerOptionId = UUID.randomUUID().toString();
        this.answerText = answerText;
        this.score = score;
        this.questionId = questionId;
    }
}
