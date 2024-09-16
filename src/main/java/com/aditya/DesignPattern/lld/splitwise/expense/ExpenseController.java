package com.aditya.DesignPattern.lld.splitwise.expense;

import com.aditya.DesignPattern.lld.splitwise.user.User;
import com.aditya.DesignPattern.lld.splitwise.user.UserBalanceSheetController;
import com.aditya.DesignPattern.lld.splitwise.expense.split.ExpenseSplit;
import com.aditya.DesignPattern.lld.splitwise.expense.split.Split;

import java.math.BigDecimal;
import java.util.List;

public class ExpenseController {

    private UserBalanceSheetController userBalanceSheetController;

    public ExpenseController() {
        this.userBalanceSheetController = new UserBalanceSheetController();
    }

    public Expense createExpense(String id, BigDecimal amount, List<Split> splitList, User paidBy, SplitType splitType) {
        ExpenseSplit expenseSplit = SplitFactory.getExpenseSplit(splitType);
        expenseSplit.validateExpense(splitList, amount);

        Expense expense = new Expense(id, amount, splitList, paidBy, splitType);
        userBalanceSheetController.updateUserBalanceSheetBasedOnExpense(expense);

        return expense;
    }
}
