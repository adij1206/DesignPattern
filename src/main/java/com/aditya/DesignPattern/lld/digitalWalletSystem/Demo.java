package com.aditya.DesignPattern.lld.digitalWalletSystem;

/**
 * <p>Requirements</p>
 * <p>The digital wallet should allow users to create an account and manage their personal information.</p>
 * <p>Users should be able to add and remove payment methods, such as credit cards or bank accounts.</p>
 * <p>The digital wallet should support fund transfers between users and to external accounts.</p>
 * <p>The system should handle transaction history and provide a statement of transactions.</p>
 * <p>The digital wallet should support multiple currencies and perform currency conversions.</p>
 * <p>The system should ensure the security of user information and transactions.</p>
 * <p>The digital wallet should handle concurrent transactions and ensure data consistency.</p>
 * <p>The system should be scalable to handle a large number of users and transactions.</p>
 */
public class Demo {

    public static void main(String[] args) {
        User user1 = new User("abc@gmail.com", "Adi");
        User user2 = new User("abd@gmail.com", "Aditya");

        Account account1 = new Account("12345", user1.getId(), 1000.0, Currency.INR);
        Account account2 = new Account("12346", user1.getId(), 1000.0, Currency.JPY);

        Account account3 = new Account("12347", user2.getId(), 1000.0, Currency.USD);
        Account account4 = new Account("12348", user2.getId(), 1000.0, Currency.JPY);

        DigitalWalletService digitalWalletService = DigitalWalletService.getInstance();

        digitalWalletService.addUSer(user1);
        digitalWalletService.addUSer(user2);

        digitalWalletService.addAccount(account1);
        digitalWalletService.addAccount(account2);
        digitalWalletService.addAccount(account3);
        digitalWalletService.addAccount(account4);

        PaymentMethod paymentMethod1 = new CreditCard(user1.getId(), "12345678", "04/28", "123");
        digitalWalletService.addPaymentMethod(paymentMethod1);

        PaymentMethod paymentMethod2 = new CreditCard(user2.getId(), "12345679", "04/28", "125");
        digitalWalletService.addPaymentMethod(paymentMethod2);

        PaymentMethod paymentMethod3 = new BankTransfer(
                user1.getId(), account1.getAccountNumber(), account2.getAccountNumber());
        digitalWalletService.addPaymentMethod(paymentMethod3);

        digitalWalletService.transferFund(
                account1.getAccountNumber(), account2.getAccountNumber(), 500, Currency.USD, paymentMethod1.getId());
        System.out.println(digitalWalletService.getAllTransactionForAccount(account1.getAccountNumber()));
        System.out.println(digitalWalletService.getAccount(account1.getAccountNumber()));
        System.out.println(digitalWalletService.getPaymentMethodOfUser(user1.getId()));

        digitalWalletService.transferFund(
                account3.getAccountNumber(), account2.getAccountNumber(), 500, Currency.USD, paymentMethod1.getId());
    }
}
