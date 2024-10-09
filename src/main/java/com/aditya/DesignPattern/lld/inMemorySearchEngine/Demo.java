package com.aditya.DesignPattern.lld.inMemorySearchEngine;

public class Demo {

    public static void main(String[] args) {
        SearchEngine searchEngine = SearchEngine.getInstance();

        searchEngine.createCategory("General Tech Articles");
        searchEngine.createCategory("Technology");
        searchEngine.createCategory("Computer Science");

        searchEngine.addDocument(
                "General Tech Articles",
                "A Beginner's Guide to Machine Learning Models",
                "Author1",
                "A Beginner's Guide to Machine Learning Models"
        );

        searchEngine.addDocument(
                "General Tech Articles",
                "Exploring Reinforcement Learning with Practical Examples",
                "Author1",
                "Exploring Reinforcement Learning with Practical Examples"
        );

        searchEngine.addDocument(
                "General Tech Articles",
                "Reinforcement Learning and applications of Deep Neural Networks in Healthcare",
                "Author1",
                "Reinforcement Learning and applications of Deep Neural Networks in Healthcare"
        );

        searchEngine.addDocument(
                "General Tech Articles",
                "Deep Learning in Computer Vision: Use Cases and Future",
                "Author1",
                "Deep Learning in Computer Vision: Use Cases and Future"
        );

        System.out.println(searchEngine.searchDocument("General Tech Articles", "Deep Learning", "UNORDERED"));

        System.out.println(searchEngine.searchDocument("General Tech Articles", "Deep Learning", "SUBSTRING"));
    }
}
