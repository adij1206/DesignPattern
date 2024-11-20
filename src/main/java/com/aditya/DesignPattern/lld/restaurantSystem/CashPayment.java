package com.aditya.DesignPattern.lld.restaurantSystem;

public class CashPayment implements PaymentModeService {

    private PaymentService paymentService;

    public CashPayment(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void processPayment(String paymentId) {
        paymentService.updateStatusAndModeOfPayment(paymentId, PaymentStatus.SUCCESS, PaymentMode.CASH.name());
    }

}
