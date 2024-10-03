package com.aditya.DesignPattern.lld.elevatorSystemV2;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Lift lift = new Lift(0, 5);

        lift.addInsideRequest(1);
        lift.addInsideRequest(2);

        lift.addOutRequest(new OutRequest(4, Direction.DOWN));
        lift.addOutRequest(new OutRequest(4, Direction.UP));

        new Thread(new Runnable() {
            @Override
            public void run() {
                lift.move();
            }
        }).start();

        lift.addInsideRequest(3);

        Thread.sleep(7000);
        lift.addOutRequest(new OutRequest(5, Direction.DOWN));
        lift.addOutRequest(new OutRequest(3, Direction.UP));
        lift.addInsideRequest(0);
    }
}
