package com.aditya.DesignPattern.lld.splitwise.expense;

import com.aditya.DesignPattern.lld.splitwise.expense.split.EqualExpenseSplit;
import com.aditya.DesignPattern.lld.splitwise.expense.split.ExpenseSplit;
import com.aditya.DesignPattern.lld.splitwise.expense.split.PercentageExpenseSplit;
import com.aditya.DesignPattern.lld.splitwise.expense.split.UnEqualExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getExpenseSplit(SplitType splitType) {
        return switch (splitType) {
            case EQUAL -> new EqualExpenseSplit();
            case UNEQUAL -> new UnEqualExpenseSplit();
            case PERCENTAGE -> new PercentageExpenseSplit();
        };
    }
}
