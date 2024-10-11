package com.aditya.DesignPattern.lld.SurveySystem;

import java.util.List;

public class SurveySystem {

    private static SurveySystem instance;
    private UserService userService;
    private SurveyService surveyService;
    private AnswerService answerService;
    private QuestionAnswerOptionService questionAnswerOptionService;

    private SurveySystem() {
        userService = new UserService();
        surveyService = new SurveyService();
        answerService = new AnswerService();
        questionAnswerOptionService = new QuestionAnswerOptionService();
    }

    public synchronized static SurveySystem getInstance() {
        if (instance == null) {
            instance = new SurveySystem();
        }

        return instance;
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public User getUser(String email) {
        return userService.getUser(email);
    }

    public boolean validateUser(String email, String password) {
        return userService.validateUser(email, password);
    }

    public Survey createSurvey(String userId, String surveyName) {
        User user = userService.getUser(userId);

        if (user.getRole().equals(Role.ADMIN)) {
            return surveyService.createSurvey(userId, surveyName);

        }

        return null;
    }

    public Survey getSurvey(String surveyId) {
        return surveyService.getSurvey(surveyId);
    }

    public List<Survey> getAllSurveysByUserId(String userId) {
        return surveyService.getAllSurveysByUserId(userId);
    }

    public void addAnswer(Answer answer) {
        List<AnswerOption> answerOptionsByQuestionId = questionAnswerOptionService.getAnswerOptionsByQuestionId(
                answer.getQuestionId());
        boolean flag = false;
        for (AnswerOption answerOption : answerOptionsByQuestionId) {
            if (answerOption.getAnswerOptionId().equals(answer.getAnswerOptionId())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Wrong ANser has been selected, please verify");
            return;
        }

        answerService.addAnswer(answer);
    }

    public Answer getAnswer(String id) {
        return answerService.getAnswer(id);
    }



    public void getAverageScoreOfTheSurvey(String surveyId) {
       List<Answer> answers =  answerService.getAnswerBySurveyId(surveyId);

       List<String> answerOptionIds = answers.stream()
               .map(Answer::getAnswerOptionId)
               .toList();

       List<AnswerOption> answerOptions = questionAnswerOptionService.getAnswerOptions(answerOptionIds);

       int averageScoreOfSurvey = 0;

       for (AnswerOption answerOption : answerOptions) {
           averageScoreOfSurvey += answerOption.getScore();
       }

       System.out.println("Avergae Score : " + averageScoreOfSurvey/answerOptions.size());
    }

    public List<Answer> getAnswerBySurveyIdAndQuestionId(String surveyId, String questionId) {
       return answerService.getAnswerBySurveyIdAndQuestionId(surveyId, questionId);
    }

    public List<Answer> getAnswerBySurveyIdAndUserId(String surveyId, String userId) {
        return answerService.getAnswerBySurveyIdAndUserId(surveyId, userId);
    }

    public void addQuestion(Question question) {
        questionAnswerOptionService.addQuestion(question);
    }

    public Question getQuestion(String questionId) {
        return questionAnswerOptionService.getQuestion(questionId);
    }

    public void showQuestionAndAnswerOfSurvey(String surveyId) {
        List<Question> questions = questionAnswerOptionService.getQuestionsBySurveyId(surveyId);

        for (Question question : questions) {
            System.out.println("Question :" + question.getQuestionText());

            List<AnswerOption> answerOptions = questionAnswerOptionService.getAnswerOptionsByQuestionId(question.getQuestionId());

            for (AnswerOption answerOption : answerOptions) {
                System.out.println("Answer Option :" + answerOption.getAnswerText());
            }
        }
    }

    public List<Question> getQuestionsBySurveyId(String surveyId) {
        return questionAnswerOptionService.getQuestionsBySurveyId(surveyId);
    }

    public void addAnswer(AnswerOption answerOption) {
       questionAnswerOptionService.addAnswer(answerOption);
    }

    public AnswerOption getAnswerOption(String answerOptionId) {
        return questionAnswerOptionService.getAnswerOption(answerOptionId);
    }

    public List<AnswerOption> getAnswerOptions(List<String> answerOptionIds) {
       return questionAnswerOptionService.getAnswerOptions(answerOptionIds);
    }

    public List<AnswerOption> getAnswerOptionsByQuestionId(String questionId) {
        return questionAnswerOptionService.getAnswerOptionsByQuestionId(questionId);
    }
}
