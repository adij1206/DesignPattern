package com.aditya.DesignPattern.lld.SurveySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionAnswerOptionService {

    private Map<String, Question> questionMap;
    private Map<String, AnswerOption> answerOptionMap;

    public QuestionAnswerOptionService() {
        questionMap = new HashMap<>();
        answerOptionMap = new HashMap<>();
    }

    public void addQuestion(Question question) {
        questionMap.put(question.getQuestionId(), question);
    }

    public Question getQuestion(String questionId) {
        return questionMap.get(questionId);
    }

    public List<Question> getQuestionsBySurveyId(String surveyId) {
        List<Question> questionList = new ArrayList<>();
        for (Question question : questionMap.values()) {
            if (question.getSurveyId().equals(surveyId)) {
                questionList.add(question);
            }
        }
        return questionList;
    }

    public void addAnswer(AnswerOption answerOption) {
        this.answerOptionMap.put(answerOption.getAnswerOptionId(), answerOption);
    }

    public AnswerOption getAnswerOption(String answerOptionId) {
        return answerOptionMap.get(answerOptionId);
    }

    public List<AnswerOption> getAnswerOptions(List<String> answerOptionIds) {
        List<AnswerOption> answerOptionList = new ArrayList<>();

        for (String answerOptionId : answerOptionIds) {
            answerOptionList.add(answerOptionMap.get(answerOptionId));
        }

        return answerOptionList;
    }

    public List<AnswerOption> getAnswerOptionsByQuestionId(String questionId) {
        List<AnswerOption> answerOptionList = new ArrayList<>();

        for (AnswerOption answerOption : answerOptionMap.values()) {
            if (answerOption.getQuestionId().equals(questionId)) {
                answerOptionList.add(answerOption);
            }
        }

        return answerOptionList;
    }
}
