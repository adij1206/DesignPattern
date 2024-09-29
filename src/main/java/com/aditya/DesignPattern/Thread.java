package com.aditya.DesignPattern;

public class Thread {

    private static boolean turn = true;

    public static void main(String[] args) {

        java.lang.Thread t1 = new java.lang.Thread(() -> {

            while (true) {
                //System.out.println("1");
                if (turn) {
                    print("Hello");
                    turn = false;
                    try {
                        java.lang.Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        });

        java.lang.Thread t2 = new java.lang.Thread(() -> {

            while (true) {
                System.out.println("2");
                if (!turn) {
                    print("World");
                    turn = true;
                    try {
                        java.lang.Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


        t1.start();
        t2.start();
    }

    private static void print(String name) {
        System.out.println(name);
    }

}
