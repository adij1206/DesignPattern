package com.aditya.DesignPattern.lld.SurveySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyService {

    private Map<String, Survey> surveyMap;

    public SurveyService() {
        this.surveyMap = new HashMap<>();
    }

    public Survey createSurvey(String userId, String surveyName) {
        Survey survey = new Survey(userId, surveyName);
        this.surveyMap.put(survey.getSurveyId(), survey);
        return survey;
    }

    public Survey getSurvey(String surveyId) {
        return this.surveyMap.get(surveyId);
    }

    public List<Survey> getAllSurveysByUserId(String userId) {
        List<Survey> surveyList = new ArrayList<>();

        for (Survey survey : this.surveyMap.values()) {
            if (survey.getUserId().equals(userId)) {
                surveyList.add(survey);
            }
        }

        return surveyList;
    }
}
