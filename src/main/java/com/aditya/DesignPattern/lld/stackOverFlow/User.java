package com.aditya.DesignPattern.lld.stackOverFlow;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private int score;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;

    private static final int QUESTION_POINT = 10;
    private static final int ANSWER_POINT = 20;
    private static final int COMMENT_POINT = 5;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.score = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Question askQuestion(String content, String title, List<String> tags) {
        Question question = new Question(content, title, this, tags);
        questions.add(question);
        updateReputation(QUESTION_POINT);

        return question;
    }

    public Answer answerQuestion(String content, Question question) {
        Answer answer = new Answer(content, question, this);
        answers.add(answer);
        updateReputation(ANSWER_POINT);

        return answer;
    }

    public Comment addComment(String content, Commentable commentable) {
        Comment comment = new Comment(content, this);
        comments.add(comment);
        updateReputation(COMMENT_POINT);

        commentable.addComment(comment);

        return comment;
    }

    public synchronized void updateReputation(int score) {
        this.score += score;

        if (score < 0) {
            this.score = 0;
        }
    }

    public int getScore() {
        return this.score;
    }
}
