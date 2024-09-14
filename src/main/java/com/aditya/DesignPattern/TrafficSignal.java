package com.aditya.DesignPattern;

public class TrafficSignal {

    public static void main(String[] args) {
        int directions = 3;
        int totalTime = 60;
        int yellowLight = 3;

        //boolean[] no = new boolean[directions];

        int t = 120;
        int i=1;
        int currentDirection = 0;
        int switchDirectionTime = totalTime/directions-yellowLight;
        int estimateTime = totalTime/directions;
        int x =1;
        while (i<=t) {

            if (i<=switchDirectionTime) {
                System.out.println(currentDirection);
            } else if (i<=estimateTime) {
                System.out.println("A");

                if (i==estimateTime) {

                    x++;
                    switchDirectionTime += totalTime/directions;
                    estimateTime = (totalTime/directions)*x;
                }
            }

            if (i%(totalTime/directions)==0) {
                currentDirection = (currentDirection+1)%directions;
            }

            i++;
        }
    }
}
