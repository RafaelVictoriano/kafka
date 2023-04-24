package com.kafka.paymentservice.service.impl;

import com.kafka.paymentservice.model.Payment;
import com.kafka.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    private final ProducerMessageService producerMessageService;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Received payment, payment: {}", payment);
        Thread.sleep(2000);
        log.info("Sending payment, payment: {}", payment);
        producerMessageService.sendMessage(payment);
    }


}
