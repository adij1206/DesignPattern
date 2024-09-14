package com.aditya.DesignPattern.lld.parkinglot;

import com.aditya.DesignPattern.lld.parkinglot.strategy.HourlyCostComputationStrategy;

public class TwoWheelerCostComputation extends CostComputation {

    public TwoWheelerCostComputation() {
        super(new HourlyCostComputationStrategy());
    }
}
