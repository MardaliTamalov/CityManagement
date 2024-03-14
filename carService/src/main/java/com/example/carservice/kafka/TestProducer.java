package com.example.carservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void testSendMessage() {
        kafkaTemplate.send("car-delete-event", "привет мир!");
    }
}
