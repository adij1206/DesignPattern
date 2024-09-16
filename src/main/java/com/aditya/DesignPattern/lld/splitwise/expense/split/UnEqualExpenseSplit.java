package com.aditya.DesignPattern.lld.splitwise.expense.split;

import java.math.BigDecimal;
import java.util.List;

public class UnEqualExpenseSplit implements ExpenseSplit {

    @Override
    public void validateExpense(List<Split> splitList, BigDecimal amount) {
        System.out.println("Validating UnEqual Expense Split");
    }
}
