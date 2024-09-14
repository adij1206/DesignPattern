package com.aditya.DesignPattern.lld.parkinglot;

import com.aditya.DesignPattern.lld.parkinglot.strategy.ICostComputationStrategy;

import java.math.BigDecimal;

public abstract class CostComputation {

    private ICostComputationStrategy iCostComputationStrategy;

    public CostComputation(ICostComputationStrategy iCostComputationStrategy) {
        this.iCostComputationStrategy = iCostComputationStrategy;
    }

    public BigDecimal computeCost(Ticket ticket) {
        return iCostComputationStrategy.price(ticket);
    }
}
