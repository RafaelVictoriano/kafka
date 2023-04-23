package com.kafka.strproducer.producer;

import com.kafka.strproducer.services.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/producer")
public class StringProducerResource {

    private final StringProducerService producerService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void producerMessage(@RequestBody String message) {
        producerService.sendMessage(message);

    }
}
