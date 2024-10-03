package com.aditya.DesignPattern.lld.elevatorSystemV2;


import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Lift {

    private int currentFloor;
    private int minFloor;
    private int maxFloor;
    private PriorityQueue<Integer> upRequest;
    private PriorityQueue<Integer> downRequest;
    private Set<Integer> deferredUpRequest;
    private Set<Integer> deferredDownRequest;
    private Direction direction;

    public Lift(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.currentFloor = 0;
        this.upRequest = new PriorityQueue<>();
        this.downRequest = new PriorityQueue<>(Collections.reverseOrder());
        this.deferredUpRequest = new HashSet<>();
        this.deferredDownRequest = new HashSet<>();
        this.direction = Direction.UP;
    }

    public void move() {
        while (true) {
            if (Direction.UP == direction) {
                processUpRequest();

                direction = Direction.DOWN;

                if (!deferredDownRequest.isEmpty()) {
                    downRequest.addAll(deferredDownRequest);
                    deferredDownRequest.clear();
                }
            }

            if (Direction.DOWN == direction) {
                processDownRequest();

                direction = Direction.UP;


                if (!deferredUpRequest.isEmpty()) {
                    upRequest.addAll(deferredUpRequest);
                    deferredUpRequest.clear();
                }
            }
        }
    }

    private void processUpRequest() {
        while (!upRequest.isEmpty()) {
            Integer floor = upRequest.poll();
            System.out.println("Up Request" + floor);
            this.currentFloor = floor;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void processDownRequest() {
        while (!downRequest.isEmpty()) {
            Integer floor = downRequest.poll();
            System.out.println("Down Request" + floor);
            this.currentFloor = floor;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addInsideRequest(int floor) {
        if (Direction.UP == direction) {
            if (currentFloor < floor) {
                upRequest.add(floor);
            } else {
                deferredUpRequest.add(floor);
            }
        } else {
            if (currentFloor < floor) {
                deferredDownRequest.add(floor);
            } else {
                downRequest.add(floor);
            }
        }
    }

    public void addOutRequest(OutRequest outRequest) {
        if (Direction.DOWN == outRequest.getDirection() && outRequest.getDirection() == direction) {
            if (outRequest.getFloorNumber() > currentFloor) {
                deferredDownRequest.add(outRequest.getFloorNumber());
            } else {
                downRequest.add(outRequest.getFloorNumber());
            }
        } else if (Direction.UP == outRequest.getDirection() && outRequest.getDirection() == direction) {
            if (outRequest.getFloorNumber() > currentFloor) {
                upRequest.add(outRequest.getFloorNumber());
            } else {
                deferredUpRequest.add(outRequest.getFloorNumber());
            }
        } else {
            if (Direction.DOWN == outRequest.getDirection()) {
                deferredDownRequest.add(outRequest.getFloorNumber());
            } else {
                deferredUpRequest.add(outRequest.getFloorNumber());
            }
        }
    }
}
