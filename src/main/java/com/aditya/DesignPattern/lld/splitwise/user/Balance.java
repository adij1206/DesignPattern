package com.aditya.DesignPattern.lld.splitwise.user;

import java.math.BigDecimal;

public class Balance {

    private BigDecimal amountOwed;
    private BigDecimal amountGetBack;

    public Balance() {
        this.amountOwed = new BigDecimal(0);
        this.amountGetBack = new BigDecimal(0);
    }

    public BigDecimal getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(BigDecimal amountOwed) {
        this.amountOwed = amountOwed;
    }

    public BigDecimal getAmountGetBack() {
        return amountGetBack;
    }

    public void setAmountGetBack(BigDecimal amountGetBack) {
        this.amountGetBack = amountGetBack;
    }
}
