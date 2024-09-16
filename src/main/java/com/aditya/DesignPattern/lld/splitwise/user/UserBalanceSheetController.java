package com.aditya.DesignPattern.lld.splitwise.user;

import com.aditya.DesignPattern.lld.splitwise.expense.Expense;
import com.aditya.DesignPattern.lld.splitwise.expense.split.Split;

import java.math.BigDecimal;
import java.util.Map;

public class UserBalanceSheetController {

    public void updateUserBalanceSheetBasedOnExpense(Expense expense) {
        User paidBy = expense.getPaidBy();
        UserExpenseBalanceSheet balanceSheet = paidBy.getBalanceSheet();
        balanceSheet.setTotalPay(balanceSheet.getTotalPay().add(expense.getTotalAmount()));

        for (Split split : expense.getSplitList()) {
            User userOwe = split.getUser();
            BigDecimal amountOwe = split.getAmount();
            UserExpenseBalanceSheet balanceSheetOwe = userOwe.getBalanceSheet();

            if (paidBy.getUserId().equals(userOwe.getUserId())) {
                balanceSheet.setTotalExpense(balanceSheet.getTotalExpense().add(amountOwe));
            } else {
                // Update Paid User Balance Sheet
                balanceSheet.setTotalGetBack(balanceSheet.getTotalGetBack().add(amountOwe));

                Balance balance;
                if (balanceSheet.getBalanceMap().containsKey(userOwe.getUserId())) {
                    balance = balanceSheet.getBalanceMap().get(userOwe.getUserId());
                } else {
                    balance = new Balance();
                    balanceSheet.getBalanceMap().put(userOwe.getUserId(), balance);
                }

                balance.setAmountGetBack(balance.getAmountGetBack().add(amountOwe));

                // Update BalanceSheet of Owed User
                balanceSheetOwe.setTotalOwed(balanceSheetOwe.getTotalOwed().add(amountOwe));
                balanceSheetOwe.setTotalExpense(balanceSheetOwe.getTotalExpense().add(amountOwe));

                Balance owedBalance;
                if (balanceSheetOwe.getBalanceMap().containsKey(paidBy.getUserId())) {
                    owedBalance = balanceSheetOwe.getBalanceMap().get(paidBy.getUserId());
                } else {
                    owedBalance = new Balance();
                    balanceSheetOwe.getBalanceMap().put(paidBy.getUserId(), owedBalance);
                }

                owedBalance.setAmountOwed(owedBalance.getAmountOwed().add(amountOwe));
            }
        }
    }

    public void showBalanceSheet(User user) {
        System.out.println("-------------------------------------------------");
        UserExpenseBalanceSheet balanceSheet = user.getBalanceSheet();
        System.out.println("User " + user.getUserId());
        System.out.println("Total Expense: " + balanceSheet.getTotalExpense());
        System.out.println("Total GetBack: " + balanceSheet.getTotalGetBack());
        System.out.println("Total Owed: " + balanceSheet.getTotalOwed());
        System.out.println("Total Payed: " + balanceSheet.getTotalPay());

        for (Map.Entry<String, Balance> entry : balanceSheet.getBalanceMap().entrySet()) {
            String userId = entry.getKey();
            Balance balance = entry.getValue();
            System.out.println(
                    "UserId : " + userId + " YouGetBack -" + balance.getAmountGetBack() + " You Owed -" + balance.getAmountOwed());
        }
        System.out.println("-------------------------------------------------");
    }
}
