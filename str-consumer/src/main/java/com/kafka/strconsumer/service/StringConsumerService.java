package com.kafka.strconsumer.service;

import com.kafka.strconsumer.config.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class StringConsumerService {


    @StrConsumerCustomListener(containerFactory = "validMessageFactory")
    public void log(String message) {
        log.info("LOG :: Received Message: {}", message);
    }

    @StrConsumerCustomListener
    public void create(String message) {
        log.info("CREATE :: Received Message: {}", message);
    }

}
