package com.aditya.DesignPattern.lld.elevatorSystem;

public class Main {

    public static void main(String[] args) {
        ElevatorService elevatorService = new ElevatorService();
        elevatorService.createElevator(4);

        elevatorService.pressButton(4, Direction.UP);
        elevatorService.pressButton(3, Direction.UP);
        elevatorService.pressButton(2, Direction.DOWN);

        elevatorService.pressButton(1, Direction.DOWN);

        elevatorService.controlElevator();
    }
}
