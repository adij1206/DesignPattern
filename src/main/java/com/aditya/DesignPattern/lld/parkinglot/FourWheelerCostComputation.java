package com.aditya.DesignPattern.lld.parkinglot;

import com.aditya.DesignPattern.lld.parkinglot.strategy.MinuteCostComputationStrategy;

public class FourWheelerCostComputation extends CostComputation {

    public FourWheelerCostComputation() {
        super(new MinuteCostComputationStrategy());
    }
}
