package com.aditya.DesignPattern.lld.digitalWalletSystem;

import java.util.List;

public class DigitalWalletService {

    private static DigitalWalletService instance;

    private UserService userService;
    private AccountService accountService;
    private TransactionService transactionService;
    private PaymentMethodService paymentMethodService;

    private DigitalWalletService() {
        this.userService = new UserService();
        this.accountService = new AccountService();
        this.paymentMethodService = new PaymentMethodService();
        this.transactionService = new TransactionService();
    }

    public static DigitalWalletService getInstance() {
        if (instance == null) {
            instance = new DigitalWalletService();
        }

        return instance;
    }

    public void addUSer(User user) {
        userService.addUSer(user);
    }

    public User getUserById(String id) {
        return userService.getUserById(id);
    }

    public void addAccount(Account account) {
        accountService.addAccount(account);
    }

    public Account getAccount(String accountNumber) {
        return accountService.getAccount(accountNumber);
    }

    public Transaction getTransactionById(String transactionId) {
        return transactionService.getTransactionById(transactionId);
    }

    public List<Transaction> getAllTransactionForAccount(String accountNumber) {
        return transactionService.getAllTransactionForAccount(accountNumber);
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodService.addPaymentMethod(paymentMethod);
    }

    public List<PaymentMethod> getPaymentMethodOfUser(String userId) {
        return paymentMethodService.getPaymentMethodOfUser(userId);
    }

    public void removePaymentMethod(String id) {
        paymentMethodService.removePaymentMethod(id);
    }

    public void transferFund(
            String sourceAccountNumber, String destinationAccountNumber, double amount, Currency currency,
            String paymentMethodId
    ) {
        Account account = accountService.getAccount(sourceAccountNumber);
        PaymentMethod paymentMethod = paymentMethodService.getPaymentMethod(paymentMethodId);

        if (!account.getUserId().equals(paymentMethod.getUserId())) {
            System.out.println("Account is not owner of this account");
            return;
        }

        if (!account.getCurrency().equals(currency)) {
            amount = CurrencyConvertor.convert(amount, currency, account.getCurrency());
        }

        accountService.debit(sourceAccountNumber, amount);

        Account destinationAccount = accountService.getAccount(destinationAccountNumber);
        if (!destinationAccount.getCurrency().equals(currency)) {
            amount = CurrencyConvertor.convert(amount, currency, destinationAccount.getCurrency());
        }

        accountService.credit(destinationAccountNumber, amount);

        Transaction transaction = new Transaction(
                sourceAccountNumber, destinationAccountNumber, amount, currency, paymentMethodId);
        transactionService.addTransaction(transaction);

        paymentMethod.processPayment(amount, currency);
    }
}
