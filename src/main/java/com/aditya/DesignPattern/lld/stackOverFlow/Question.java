package com.aditya.DesignPattern.lld.stackOverFlow;

import java.util.ArrayList;
import java.util.List;

public class Question implements Votable, Commentable {

    private int id;
    private String title;
    private String content;
    private User author;
    private List<Comment> commentList;
    private List<Answer> answerList;
    private List<Vote> voteList;
    private List<String> tagList;
    private Long creationDate;

    public Question(String content, String title, User author, List<String> tag) {
        this.id = generateId();
        this.content = content;
        this.title = title;
        this.author = author;
        this.tagList = tag;
        this.commentList = new ArrayList<>();
        this.answerList = new ArrayList<>();
        this.voteList = new ArrayList<>();
        this.creationDate = System.currentTimeMillis();
    }

    @Override
    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return new ArrayList<>(commentList);
    }

    @Override
    public void vote(User user, int value) {
        if (value != -1 && value != 1) {
            System.out.println("Wrong value! Please check");
            return;
        }

        voteList.removeIf(v -> v.getUser().equals(user));

        Vote vote = new Vote(value, user);
        voteList.add(vote);
    }

    @Override
    public int getVoteCount() {
        return voteList.stream().mapToInt(Vote::getValue).sum();
    }

    public void addAnswer(Answer answer) {
        if (!answerList.contains(answer)) {
            answerList.add(answer);
        }
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void addTag(String tag) {
        this.tagList.add(tag);
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public List<String> getTags() {
        return this.tagList;
    }
}
