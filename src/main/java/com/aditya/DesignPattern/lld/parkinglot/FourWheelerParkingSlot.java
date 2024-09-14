package com.aditya.DesignPattern.lld.parkinglot;

import java.math.BigDecimal;

public class FourWheelerParkingSlot extends ParkingSlot {

    public FourWheelerParkingSlot(String id, Boolean isEmpty, BigDecimal price, String type) {
        super(id, isEmpty, price, type);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(20);
    }
}
