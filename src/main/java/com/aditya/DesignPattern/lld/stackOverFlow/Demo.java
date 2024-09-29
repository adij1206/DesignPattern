package com.aditya.DesignPattern.lld.stackOverFlow;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        StackOverFlow stackOverFlow = new StackOverFlow();

        User aditya = stackOverFlow.createUser("Aditya");
        User abhigyan = stackOverFlow.createUser("Abhigyan");
        User satyam = stackOverFlow.createUser("Satyam");

        Question question = stackOverFlow.createQuestion("What is difference between LRU and LFU cache",
                                                         "Difference between LRU and LFU",
                                                         Arrays.asList("Java", "Cache"), aditya
        );

        Answer answer = stackOverFlow.answerQuestion(abhigyan, question, "ABC");

        stackOverFlow.addComment(satyam, question, "Abc");
        stackOverFlow.addComment(satyam, answer, "Abc");

        stackOverFlow.voteAnswer(aditya, answer, 1);
        stackOverFlow.voteQuestion(abhigyan, question, 1);

        stackOverFlow.acceptAnswer(answer);

        System.out.println(stackOverFlow.getQuestion(question.getId()).getVoteCount());

        System.out.println(aditya.getScore());
        System.out.println(abhigyan.getScore());
        System.out.println(satyam.getScore());
    }
}
