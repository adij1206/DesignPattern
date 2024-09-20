package com.aditya.DesignPattern.lld.elevatorSystem;

import java.util.*;

public class ElevatorService {

    private PriorityQueue<Integer> ascendingFloors;
    private PriorityQueue<Integer> descendingFloors;
    private Queue<Integer> pendingFloors;
    private Elevator elevator;



    public ElevatorService() {
        ascendingFloors = new PriorityQueue<>();
        descendingFloors = new PriorityQueue<>((a,b) -> b-a);
        pendingFloors = new LinkedList<>();
    }

    public void createElevator(int noOfFloors) {
        List<Integer> buttons = new ArrayList<>();

        for (int i=0;i<=noOfFloors;i++) {
            buttons.add(i);
        }

        this.elevator = new Elevator(buttons, 0, Direction.UP, true);
    }

    public void pressButton(int floorNumber, Direction direction) {
//        if (direction == Direction.UP && floorNumber < elevator.getCurrentFloor()) {
//            pendingFloors.add(floorNumber);
//        } else if (direction == Direction.DOWN && floorNumber > elevator.getCurrentFloor()) {
//            pendingFloors.add(floorNumber);
//        }
//        else {
            if (direction == Direction.UP) {
                System.out.println("Adding Up Request to floor " + floorNumber);
                ascendingFloors.add(floorNumber);
            } else {
                System.out.println("Adding Down Request to floor " + floorNumber);
                descendingFloors.add(floorNumber);
            }
       // }
    }

    public void controlElevator() {
        boolean isActive = elevator.getActive();
        while (isActive) {

            if (elevator.getDirection()==Direction.UP) {

                while (!ascendingFloors.isEmpty()) {
                    Integer floor = ascendingFloors.poll();
                    elevator.setCurrentFloor(floor);
                    System.out.println("Elevator Stopped at floor " + floor);
                }

                while(!pendingFloors.isEmpty()) {
                    ascendingFloors.add(pendingFloors.poll());
                }

                elevator.setDirection(Direction.DOWN);

                if (descendingFloors.isEmpty()) {
                    isActive = false;
                    elevator.setActive(false);
                }
            } else {
                while (!descendingFloors.isEmpty()) {
                    Integer floor = descendingFloors.poll();
                    elevator.setCurrentFloor(floor);
                    System.out.println("Elevator Stopped at floor " + floor);
                }

                while(!pendingFloors.isEmpty()) {
                    descendingFloors.add(pendingFloors.poll());
                }

                elevator.setDirection(Direction.UP);

                if (ascendingFloors.isEmpty()) {
                    isActive = false;
                    elevator.setActive(false);
                }
            }
        }
    }

}
