package com.aditya.DesignPattern.lld.splitwise.group;

import com.aditya.DesignPattern.lld.splitwise.user.User;
import com.aditya.DesignPattern.lld.splitwise.expense.Expense;
import com.aditya.DesignPattern.lld.splitwise.expense.ExpenseController;
import com.aditya.DesignPattern.lld.splitwise.expense.split.Split;
import com.aditya.DesignPattern.lld.splitwise.expense.SplitType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupId;
    private String groupName;
    private List<User> users;
    private List<Expense> expenses;
    private ExpenseController expenseController;

    public Group() {
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.expenseController = new ExpenseController();
    }

    public void addMembers(User user) {
        this.users.add(user);
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public Expense createExpense(
            String id, BigDecimal amount, List<Split> splitList, User paidBy, SplitType splitType
    ) {
        Expense expense = expenseController.createExpense(id, amount, splitList, paidBy, splitType);

        expenses.add(expense);
        return expense;
    }
}
