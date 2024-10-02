package com.aditya.DesignPattern.lld.elevatorSystem;

public class Main {

    public static void main(String[] args) {
        ElevatorService elevatorService = new ElevatorService();
        elevatorService.createElevator(4);

        new Thread(new Runnable() {
            @Override
            public void run() {
                elevatorService.controlElevator();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        elevatorService.pressButton(4, Direction.UP);
        elevatorService.pressButton(0);

        elevatorService.pressButton(3, Direction.UP);
        elevatorService.pressButton(4);
        elevatorService.pressButton(2, Direction.DOWN);

        elevatorService.pressButton(1, Direction.DOWN);
        elevatorService.pressButton(4);
    }
}
