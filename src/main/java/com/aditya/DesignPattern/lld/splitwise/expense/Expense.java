package com.aditya.DesignPattern.lld.splitwise.expense;

import com.aditya.DesignPattern.lld.splitwise.user.User;
import com.aditya.DesignPattern.lld.splitwise.expense.split.Split;

import java.math.BigDecimal;
import java.util.List;

public class Expense {

    private String id;
    private BigDecimal totalAmount;
    private List<Split> splitList;
    private User paidBy;
    private SplitType splitType;

    public Expense(String id, BigDecimal totalAmount, List<Split> splitList, User paidBy, SplitType splitType) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.splitList = splitList;
        this.paidBy = paidBy;
        this.splitType = splitType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }
}
