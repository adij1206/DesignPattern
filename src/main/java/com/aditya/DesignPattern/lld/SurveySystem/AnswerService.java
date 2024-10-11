package com.aditya.DesignPattern.lld.SurveySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerService {

    private Map<String, Answer> answers;

    public AnswerService() {
        answers = new HashMap<>();
    }

    public void addAnswer(Answer answer) {
        this.answers.put(answer.getId(), answer);
    }

    public Answer getAnswer(String id) {
        return this.answers.get(id);
    }

    public List<Answer> getAnswerBySurveyId(String surveyId) {
        List<Answer> answers = new ArrayList<>();

        for (Answer answer : this.answers.values()) {
            if (answer.getSurveyId().equals(surveyId)) {
                answers.add(answer);
            }
        }

        return answers;
    }

    public List<Answer> getAnswerBySurveyIdAndQuestionId(String surveyId, String questionId) {
        List<Answer> answers = new ArrayList<>();

        for (Answer answer : this.answers.values()) {
            if (answer.getSurveyId().equals(surveyId) && answer.getQuestionId().equals(questionId)) {
                answers.add(answer);
            }
        }

        return answers;
    }

    public List<Answer> getAnswerBySurveyIdAndUserId(String surveyId, String userId) {
        List<Answer> answers = new ArrayList<>();

        for (Answer answer : this.answers.values()) {
            if (answer.getSurveyId().equals(surveyId) && answer.getUserId().equals(userId)) {
                answers.add(answer);
            }
        }

        return answers;
    }
}
