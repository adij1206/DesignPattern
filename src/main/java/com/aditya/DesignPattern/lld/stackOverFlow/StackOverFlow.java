package com.aditya.DesignPattern.lld.stackOverFlow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StackOverFlow {

    private Map<Integer, User> userMap;
    private Map<Integer, Question> questionMap;
    private Map<Integer, Answer> answerMap;

    public StackOverFlow() {
        userMap = new HashMap<>();
        questionMap = new HashMap<>();
        answerMap = new HashMap<>();
    }

    public User createUser(String name) {
        User user = new User(this.userMap.size() + 1, name);
        this.userMap.put(this.userMap.size(), user);

        return user;
    }

    public Question createQuestion(String content, String title, List<String> tags, User user) {
        Question question = user.askQuestion(content, title, tags);
        questionMap.put(question.getId(), question);

        return question;
    }

    public Answer answerQuestion(User user, Question question, String content) {
        Answer answer = user.answerQuestion(content, question);
        answerMap.put(answer.getId(), answer);

        return answer;
    }

    public Comment addComment(User user, Commentable commentable, String content) {
        return user.addComment(content, commentable);
    }

    public void voteQuestion(User user, Question question, int value) {
        question.vote(user, value);
    }

    public void voteAnswer(User user, Answer answer, int value) {
        answer.vote(user, value);
    }

    public void acceptAnswer(Answer answer) {
        answer.markAsAccepted();
    }

    public List<Question> searchQuestions(String query) {
        return questionMap.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                        q.getTags().stream().anyMatch(t -> t.equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }

    public Question getQuestion(int id) {
        return questionMap.get(id);
    }
}
