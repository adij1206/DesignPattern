package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import lombok.Data;

import java.util.*;

@Data
public class PortFolio {

    private String portfolioId;
    private String accountId;
    private Map<String, List<UserStock>> portfolio;
    private double totalInvested;

    public PortFolio(String accountId) {
        this.portfolioId = UUID.randomUUID().toString();
        this.accountId = accountId;
        this.portfolio = new LinkedHashMap<>();
        this.totalInvested = 0.0;
    }

    public void addStock(UserStock stock) {
        List<UserStock> orDefault = portfolio.getOrDefault(stock.getStockId(), new ArrayList<>());
        orDefault.add(stock);
        portfolio.put(stock.getStockId(), orDefault);
        calculatePrice(stock);
    }

    private void calculatePrice(UserStock stock) {
        totalInvested += stock.getPrice()*stock.getQuantity();
    }

    public List<UserStock> getStock(String stockId) {
        return portfolio.get(stockId);
    }
}
