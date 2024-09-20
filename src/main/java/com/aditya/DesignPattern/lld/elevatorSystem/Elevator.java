package com.aditya.DesignPattern.lld.elevatorSystem;

import java.util.List;

public class Elevator {

    private List<Integer> buttons;
    private Integer currentFloor;
    private Direction direction;
    private Boolean isActive;

    public Elevator(List<Integer> buttons, Integer currentFloor, Direction direction, Boolean isActive) {
        this.buttons = buttons;
        this.currentFloor = currentFloor;
        this.direction = direction;
        this.isActive = isActive;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Integer> getButtons() {
        return buttons;
    }

    public void setButtons(List<Integer> buttons) {
        this.buttons = buttons;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
