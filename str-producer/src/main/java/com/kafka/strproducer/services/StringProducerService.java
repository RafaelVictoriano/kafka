package com.kafka.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(final String message) {
        log.info("Sending message to topic, message:{}", message);
        final var future = kafkaTemplate.send("str-topic", message);

        future.whenComplete((result, error) -> {
            Optional.ofNullable(result)
                    .ifPresentOrElse(r -> {
                        log.info("Sent message to topic, message:{}, offset:{}, partition:{}", message,
                                r.getRecordMetadata().offset(), r.getRecordMetadata().partition());
                    }, () -> {
                        log.error("Erro send message, error:{}", error.getMessage());
                    });
        });

    }
}
