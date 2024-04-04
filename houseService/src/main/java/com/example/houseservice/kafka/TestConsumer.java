package com.example.houseservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestConsumer {
    private final ObjectMapper objectMapper;

    @KafkaListener(groupId = "HouseTestGroup", topics ="demo")
    public void proceed(@Payload String payload) throws JsonProcessingException {
//        String request = objectMapper.readValue(payload, String.class);
//         выведи на экран
   System.out.println(payload);
    }
}
