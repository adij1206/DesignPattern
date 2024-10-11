package com.aditya.DesignPattern.lld.SurveySystem;

public class Demo {

    public static void main(String[] args) {
        SurveySystem surveySystem = SurveySystem.getInstance();

        User user1 = new User("abc@gmail.com", "1234", "Adi", Role.ADMIN);
        User user2 = new User("abd@gmail.com", "1235", "Aditya", Role.VOTER);
        User user3 = new User("abe@gmail.com", "1236", "Aditya", Role.VOTER);
        User user4 = new User("abf@gmail.com", "1237", "Aditya", Role.VOTER);

        surveySystem.addUser(user1);
        surveySystem.addUser(user2);
        surveySystem.addUser(user3);
        surveySystem.addUser(user4);

        Survey survey1 = surveySystem.createSurvey(user1.getEmail(), "Survey1");

        Question question = new Question("Are you introvert", survey1.getSurveyId());
        surveySystem.addQuestion(question);

        AnswerOption answerOption1 = new AnswerOption("Always False", 0, question.getQuestionId());
        AnswerOption answerOption2 = new AnswerOption("False", 1, question.getQuestionId());
        AnswerOption answerOption3 = new AnswerOption("Not False Not True", 2, question.getQuestionId());
        AnswerOption answerOption4 = new AnswerOption("True", 3, question.getQuestionId());
        AnswerOption answerOption5 = new AnswerOption("Always True", 4, question.getQuestionId());

        surveySystem.addAnswer(answerOption1);
        surveySystem.addAnswer(answerOption2);
        surveySystem.addAnswer(answerOption3);
        surveySystem.addAnswer(answerOption4);
        surveySystem.addAnswer(answerOption5);

        Question question1 = new Question("Are you extrovert", survey1.getSurveyId());
        surveySystem.addQuestion(question1);

        AnswerOption answerOption6 = new AnswerOption("Always False", 0, question1.getQuestionId());
        AnswerOption answerOption7 = new AnswerOption("False", 1, question1.getQuestionId());
        AnswerOption answerOption8 = new AnswerOption("Not False Not True", 2, question1.getQuestionId());
        AnswerOption answerOption9 = new AnswerOption("True", 3, question1.getQuestionId());
        AnswerOption answerOption10 = new AnswerOption("Always True", 4, question1.getQuestionId());

        surveySystem.addAnswer(answerOption6);
        surveySystem.addAnswer(answerOption7);
        surveySystem.addAnswer(answerOption8);
        surveySystem.addAnswer(answerOption9);
        surveySystem.addAnswer(answerOption10);

        System.out.println(surveySystem.getSurvey(survey1.getSurveyId()).getSurveyName());
        surveySystem.showQuestionAndAnswerOfSurvey(survey1.getSurveyId());

        Answer answer = new Answer(user2.getEmail(), survey1.getSurveyId(), question.getQuestionId(),
                                   answerOption1.getAnswerOptionId()
        );

        Answer answer1 = new Answer(user2.getEmail(), survey1.getSurveyId(), question1.getQuestionId(),
                                    answerOption9.getAnswerOptionId()
        );
        surveySystem.addAnswer(answer);
        surveySystem.addAnswer(answer1);


        System.out.println(surveySystem.getSurvey(survey1.getSurveyId()).getSurveyName());
        surveySystem.showQuestionAndAnswerOfSurvey(survey1.getSurveyId());

        Answer answer2 = new Answer(user3.getEmail(), survey1.getSurveyId(), question.getQuestionId(),
                                    answerOption5.getAnswerOptionId()
        );

        Answer answer3 = new Answer(user3.getEmail(), survey1.getSurveyId(), question1.getQuestionId(),
                                    answerOption8.getAnswerOptionId()
        );
        surveySystem.addAnswer(answer2);
        surveySystem.addAnswer(answer3);

        System.out.println(
                surveySystem.getAnswerBySurveyIdAndQuestionId(survey1.getSurveyId(), question1.getQuestionId()));
        System.out.println(surveySystem.getAnswerBySurveyIdAndUserId(survey1.getSurveyId(), user2.getEmail()));

        surveySystem.getAverageScoreOfTheSurvey(survey1.getSurveyId());
    }
}
