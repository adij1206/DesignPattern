package com.aditya.DesignPattern.lld.splitwise.expense.split;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseSplit {

    public void validateExpense(List<Split> splitList, BigDecimal amount);
}
