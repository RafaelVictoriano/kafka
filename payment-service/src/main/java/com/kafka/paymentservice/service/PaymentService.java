package com.kafka.paymentservice.service;

import com.kafka.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
