package com.aditya.DesignPattern.lld.stackOverFlow;

import java.util.ArrayList;
import java.util.List;

public class Answer implements Votable, Commentable{

    private int id;
    private String content;
    private Question question;
    private List<Comment> commentList;
    private Boolean accepted;
    private List<Vote> voteList;
    private User author;
    private Long creationDate;

    public Answer(String content,  Question question, User user) {
        this.content = content;
        this.question = question;
        this.author = user;
        this.id = generateId();

        this.commentList = new ArrayList<>();
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

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return this.id;
    }

    public void markAsAccepted() {
        this.accepted = true;
        this.author.updateReputation(15);
    }
}
