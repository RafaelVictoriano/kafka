package com.kafka.strproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;

@RequiredArgsConstructor
@Configuration
public class KafkaAdminConfig {

    public final KafkaProperties kafkaProperties;


    @Bean
    public KafkaAdmin kafkaAdmin() {
        final Map<String, Object> configs = Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    @Bean
    public KafkaAdmin.NewTopics topic() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("str-topic")
                        .partitions(2)
                        .replicas(1)
                        .build()
        );
    }


}
