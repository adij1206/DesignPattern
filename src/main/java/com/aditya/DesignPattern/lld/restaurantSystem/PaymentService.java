package com.aditya.DesignPattern.lld.restaurantSystem;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    Map<String, Payment> paymentMap;

    public PaymentService() {
        paymentMap = new HashMap<>();
    }

    public void addPayment(Payment payment) {
        paymentMap.put(payment.getId(), payment);
    }

    public Payment getPaymentById(String id) {
        return paymentMap.get(id);
    }

    public void updateStatusAndModeOfPayment(String id, PaymentStatus status, String modeOfPayment) {
        Payment payment = paymentMap.get(id);

        if (!PaymentStatus.PENDING.name().equals(payment.getStatus())) {
            System.out.println("Payment is already updated");
            return;
        }

        payment.setModeOfPayment(modeOfPayment);
        payment.setStatus(status.name());
    }
}
