package com.kafka.paymentservice.resourse.impl;

import com.kafka.paymentservice.model.Payment;
import com.kafka.paymentservice.resourse.PaymentResource;
import com.kafka.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;


@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentResourceImpl implements PaymentResource {

    @Autowired
    private final PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(CREATED).build();
    }

}
