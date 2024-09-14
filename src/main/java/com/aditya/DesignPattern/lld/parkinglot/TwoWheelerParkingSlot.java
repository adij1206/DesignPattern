package com.aditya.DesignPattern.lld.parkinglot;

import java.math.BigDecimal;

public class TwoWheelerParkingSlot extends ParkingSlot {

    public TwoWheelerParkingSlot(String id, Boolean isEmpty, BigDecimal price, String type) {
        super(id, isEmpty, price, type);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(10);
    }
}