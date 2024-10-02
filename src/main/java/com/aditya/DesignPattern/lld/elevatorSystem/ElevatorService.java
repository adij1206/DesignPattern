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

    public void pressButton(int floorNumber) {
        if (elevator.getDirection().equals(Direction.UP)) {
            if (elevator.getCurrentFloor()<floorNumber) {
                ascendingFloors.add(floorNumber);
            } else {
                pendingFloors.add(floorNumber);
            }
        }

        if (elevator.getDirection().equals(Direction.DOWN) ) {
            if (elevator.getCurrentFloor()>floorNumber) {
                descendingFloors.add(floorNumber);
            } else {
                pendingFloors.add(floorNumber);
            }
        }

        if (!elevator.getActive()) {
            elevator.setActive(true);
        }
    }

    public void pressButton(int userCurrentFloorNumber, Direction direction) {
        if (direction == Direction.UP && userCurrentFloorNumber < elevator.getCurrentFloor()) {
            System.out.println("Adding Request in Pending Queue" + userCurrentFloorNumber);
            pendingFloors.add(userCurrentFloorNumber);
        } else if (direction == Direction.DOWN && userCurrentFloorNumber > elevator.getCurrentFloor()) {
            System.out.println("Adding Request in Pending Queeu" + userCurrentFloorNumber);
            pendingFloors.add(userCurrentFloorNumber);
        }
        else {
            if (direction == Direction.UP) {
                System.out.println("Adding Up Request to floor " + userCurrentFloorNumber);
                ascendingFloors.add(userCurrentFloorNumber);
            } else {
                System.out.println("Adding Down Request to floor " + userCurrentFloorNumber);
                descendingFloors.add(userCurrentFloorNumber);
            }
        }

        if (!elevator.getActive()) {
            elevator.setActive(true);
        }
    }

    public void controlElevator() {
//        boolean isActive = elevator.getActive();
        while (true) {

            if (elevator.getDirection()==Direction.UP) {

                while (!ascendingFloors.isEmpty()) {
                    Integer floor = ascendingFloors.poll();
                    elevator.setCurrentFloor(floor);
                    System.out.println("Elevator Stopped at floor " + floor);
                }

                while(!pendingFloors.isEmpty()) {
                    descendingFloors.add(pendingFloors.poll());
                }

                elevator.setDirection(Direction.DOWN);
            } else {
                while (!descendingFloors.isEmpty()) {
                    Integer floor = descendingFloors.poll();
                    elevator.setCurrentFloor(floor);
                    System.out.println("Elevator Stopped at floor " + floor);
                }

                while(!pendingFloors.isEmpty()) {
                    ascendingFloors.add(pendingFloors.poll());
                }

                elevator.setDirection(Direction.UP);
            }
        }
    }

}
