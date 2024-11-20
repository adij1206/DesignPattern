package com.aditya.DesignPattern.lld.restaurantSystem;

public class CardPayment implements PaymentModeService {

    private PaymentService paymentService;

    public CardPayment(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void processPayment(String paymentId) {
        paymentService.updateStatusAndModeOfPayment(paymentId, PaymentStatus.SUCCESS, PaymentMode.CARD.name());
    }
}
