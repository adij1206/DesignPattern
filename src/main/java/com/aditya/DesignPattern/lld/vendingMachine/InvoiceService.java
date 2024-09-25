package com.aditya.DesignPattern.lld.vendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceService {

    Map<Currency, Integer> currencyMap;

    public InvoiceService() {
        currencyMap = new HashMap<>();
    }

//    public boolean checkIfChangeExist(int amount) {
//        // Logic
//    }

    public void pay(List<Currency> currencyList) {
        for (Currency currency : currencyList) {
            Integer orDefault = currencyMap.getOrDefault(currency, 0);
            currencyMap.put(currency, orDefault + 1);
        }
    }
}
