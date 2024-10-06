package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockService {

    private Map<String, Stock> stocks;

    public StockService() {
        stocks = new HashMap<>();
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getId(), stock);
    }

    public Stock getStock(String id) {
        return stocks.get(id);
    }

    public List<Stock> getStocks() {
        return new ArrayList<>(stocks.values());
    }

    public void sellStockQuantity(String id, int quantity) {
        Stock stock = stocks.get(id);
        stock.setQuantity(stock.getQuantity() - quantity);
    }

    public void addStockQuantity(String id, int quantity) {
        Stock stock = stocks.get(id);
        stock.setQuantity(stock.getQuantity() + quantity);
    }
}
