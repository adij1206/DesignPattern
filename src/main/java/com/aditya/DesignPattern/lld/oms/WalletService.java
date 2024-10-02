package com.aditya.DesignPattern.lld.oms;

import java.util.HashMap;
import java.util.Map;

public class WalletService {

    private Map<String, Wallet> walletMap;
    public WalletService() {
        walletMap = new HashMap<>();
    }

    public void addWallet(Wallet wallet) {
        walletMap.put(wallet.getWalletId(), wallet);
    }

    public Wallet getWalletByWalletId(String walletId) {
        return walletMap.get(walletId);
    }
}
