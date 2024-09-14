package com.aditya.DesignPattern.lld.parkinglot.strategy;

import com.aditya.DesignPattern.lld.parkinglot.Ticket;

import java.math.BigDecimal;

public class MinuteCostComputationStrategy implements ICostComputationStrategy {

    @Override
    public BigDecimal price(Ticket ticket) {
        long l = System.currentTimeMillis() - ticket.getStartTime();
        BigDecimal bigDecimal = new BigDecimal((l / 60));
        return bigDecimal.multiply(ticket.getParkingSpot().getPrice());
    }
}
