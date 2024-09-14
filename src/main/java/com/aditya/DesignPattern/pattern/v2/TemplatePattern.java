package com.aditya.DesignPattern.pattern.v2;

/*
 * Template Pattern : Used when classes have to follow specific steps to process the task
 * but has flexibility to modify the specific step logic.
 */
public class TemplatePattern {

    public static void main(String[] args) {
        PaymentGateway payToFriend= new PayToFriend();
        payToFriend.pay();

        PaymentGateway payToMerchant = new PayToMerchant();
        payToMerchant.pay();
    }
}

abstract class PaymentGateway {

    abstract void validate();

    abstract void debit();

    abstract void credit();

    abstract void computeFee();

    public final void pay() {
        validate();
        debit();
        computeFee();
        credit();
    }
}

class PayToFriend extends PaymentGateway {

    @Override
    void validate() {
        System.out.println("Validate Pay to Friend");
    }

    @Override
    void debit() {
        System.out.println("Debit Amount for Pay to Friend");
    }

    @Override
    void credit() {
        System.out.println("Credit Amount for Pay to Friend");
    }

    @Override
    void computeFee() {
        System.out.println("Compute Fee For Pay to Friend");
    }
}

class PayToMerchant extends PaymentGateway {

    @Override
    void validate() {
        System.out.println("Validate Pay to Merchant");
    }

    @Override
    void debit() {
        System.out.println("Debit For Pay to Merchant");
    }

    @Override
    void credit() {
        System.out.println("Credit for Pay to Merchant");
    }

    @Override
    void computeFee() {
        System.out.println("Compute Fee for Pay to Merchant");
    }
}
