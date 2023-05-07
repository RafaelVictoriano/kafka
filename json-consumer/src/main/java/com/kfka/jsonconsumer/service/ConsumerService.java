package com.kfka.jsonconsumer.service;

import com.kfka.jsonconsumer.model.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ConsumerService {


    @KafkaListener(topics = "payment-topic", groupId = "payment-consumer",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumerMessage(@Payload Payment payment) {
        log.info("LOG :: Received Message: {}", payment.toString());
    }
}
