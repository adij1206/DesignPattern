package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PortfolioService {

    private Map<String, PortFolio> portFolioMap;

    public PortfolioService() {
        portFolioMap = new HashMap<>();
    }

    public PortFolio createPortfolio(String accountId) {
        PortFolio portfolio = new PortFolio(accountId);
        portFolioMap.put(accountId, portfolio);
        return portfolio;
    }

    public void addStock(UserStock userStock, String accountId) {
        PortFolio portFolio = portFolioMap.get(accountId);
        portFolio.addStock(userStock);

        portFolioMap.put(accountId, portFolio);
    }

    public PortFolio getPortfolio(String accountId) {
        return portFolioMap.get(accountId);
    }

    public List<UserStock> getStocks(String accountId, String stockId) {
        PortFolio portfolio = portFolioMap.get(accountId);
        return portfolio.getStock(stockId);
    }

    public void sellStock(String accountId, String stockId, int quantity) {
        PortFolio portfolio = portFolioMap.get(accountId);

        List<UserStock> stock = portfolio.getStock(stockId);
//        for (UserStock userStock : stock) {
//            if (userStock.getQuantity() <= quantity) {
//                portfolio.getPortfolio().get(stockId).remove(userStock);
//                quantity -= userStock.getQuantity();
//            } else {
//                userStock.setQuantity(userStock.getQuantity() - quantity);
//                break;
//            }
//        }

        Iterator<UserStock> iterator = stock.iterator();
        while (iterator.hasNext()) {
            UserStock userStock = iterator.next();

            if (userStock.getQuantity() <= quantity) {
                // Remove the stock from the portfolio if fully sold
                iterator.remove();
                quantity -= userStock.getQuantity();
            } else {
                // Reduce the quantity of the stock
                userStock.setQuantity(userStock.getQuantity() - quantity);
                quantity = 0;
            }

            // Exit the loop if all required stocks are sold
            if (quantity == 0) {
                break;
            }
        }

        portfolio.getPortfolio().put(stockId, stock);
    }
}
