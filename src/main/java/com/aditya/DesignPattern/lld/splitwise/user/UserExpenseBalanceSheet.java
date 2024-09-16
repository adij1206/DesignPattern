package com.aditya.DesignPattern.lld.splitwise.user;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {

    private BigDecimal totalExpense;
    private BigDecimal totalPay;
    private BigDecimal totalOwed;
    private BigDecimal totalGetBack;
    private Map<String, Balance> balanceMap;

    public UserExpenseBalanceSheet() {
        this.balanceMap = new HashMap<>();
        this.totalExpense = BigDecimal.ZERO;
        this.totalPay = BigDecimal.ZERO;
        this.totalOwed = BigDecimal.ZERO;
        this.totalGetBack = BigDecimal.ZERO;
    }

    public BigDecimal getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    public BigDecimal getTotalOwed() {
        return totalOwed;
    }

    public void setTotalOwed(BigDecimal totalOwed) {
        this.totalOwed = totalOwed;
    }

    public BigDecimal getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(BigDecimal totalGetBack) {
        this.totalGetBack = totalGetBack;
    }

    public Map<String, Balance> getBalanceMap() {
        return balanceMap;
    }

    public void setBalanceMap(
            Map<String, Balance> balanceMap
    ) {
        this.balanceMap = balanceMap;
    }
}
