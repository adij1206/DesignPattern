package com.aditya.DesignPattern.lld.digitalWalletSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {

    private Map<String, Transaction> transactionMap;

    public TransactionService() {
        this.transactionMap = new HashMap<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactionMap.put(transaction.getId(), transaction);
    }

    public Transaction getTransactionById(String transactionId) {
        return transactionMap.get(transactionId);
    }

    public List<Transaction> getAllTransactionForAccount(String accountNumber) {
        List<Transaction> transactionList = new ArrayList<>();

        for (Transaction transaction : transactionMap.values()) {
            if (transaction.getSourceAccountNumber().equals(accountNumber) || transaction.getDestinationAccountNumber().equals(accountNumber)) {
                transactionList.add(transaction);
            }
        }

        return transactionList;
    }
}
