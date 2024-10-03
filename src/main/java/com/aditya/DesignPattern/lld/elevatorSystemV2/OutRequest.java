package com.aditya.DesignPattern.lld.elevatorSystemV2;

import lombok.Data;

@Data
public class OutRequest {

    private int floorNumber;
    private Direction direction;

    public OutRequest(int floorNumber, Direction direction) {
        this.floorNumber = floorNumber;
        this.direction = direction;
    }
}
