package com.aditya.DesignPattern.lld.digitalWalletSystem;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConvertor {

    private static final Map<Currency, Double> exchangeRates = new HashMap<>();

    static {
        // Initialize exchange rates
        exchangeRates.put(Currency.USD, 1.0);
        exchangeRates.put(Currency.JPY, 0.72);
        exchangeRates.put(Currency.INR, 110.00);
        // Add more exchange rates as needed
    }

    public static double convert(double amount, Currency sourceCurrency, Currency targetCurrency) {
        double sourceRate = exchangeRates.get(sourceCurrency);
        double targetRate = exchangeRates.get(targetCurrency);
        return amount * (sourceRate) / (targetRate);
    }
}
