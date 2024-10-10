package com.aditya.DesignPattern.lld.customThreadPool;

public class Executor {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task("Abc");
        Task task1 = new Task("Abd");
        Task task2 = new Task("Abe");
        Task task3 = new Task("Abf");
        Task task4 = new Task("Abg");
        Task task5 = new Task("Abh");

        CustomThreadPool threadPool = new CustomThreadPool(2);


        Thread.sleep(1000);
        threadPool.execute(task);
        threadPool.execute(task1);
        threadPool.execute(task2);
        threadPool.execute(task3);
        threadPool.execute(task4);
        threadPool.execute(task5);

    }
}
