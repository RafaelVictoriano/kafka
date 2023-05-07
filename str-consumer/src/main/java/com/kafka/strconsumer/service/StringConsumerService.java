package com.kafka.strconsumer.service;

import com.kafka.strconsumer.config.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class StringConsumerService {


    @SneakyThrows
    @StrConsumerCustomListener()
    public void log(String message) {
        log.info("LOG :: Received Message: {}", message);
    }

    @StrConsumerCustomListener
    public void create(String message) {
        log.info("CREATE :: Received Message: {}", message);
    }

}
