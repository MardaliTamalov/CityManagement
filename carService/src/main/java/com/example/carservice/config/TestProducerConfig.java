package com.example.carservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@Configuration
@RequiredArgsConstructor

public class TestProducerConfig {
private final KafkaProperties kafkaProperties;

    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = kafkaProperties.getProducer().buildProperties(null);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplateDeleteEvent() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic deleteEvent() {
        return new NewTopic("car_delete_event", 1, (short) 1);
    }
}
