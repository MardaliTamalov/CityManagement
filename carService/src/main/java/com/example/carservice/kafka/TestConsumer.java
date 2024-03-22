package com.example.carservice.kafka;

import com.example.api.kafka.CitizenDeleteDto;
import com.example.carservice.repository.CarRepository;
import com.example.carservice.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestConsumer {
    private final CarService carService;
    private final ObjectMapper objectMapper;

    @KafkaListener(groupId = "TestGroup", topics = "demo")
    public void proceed(@Payload String payload) throws JsonProcessingException {
//        String request = objectMapper.readValue(payload, String.class);
//         выведи на экран
        System.out.println(payload);
    }

    @KafkaListener(groupId = "CarGroup", topics = "car_delete_event")
    public void carDelete(CitizenDeleteDto citizenDeleteDto) {
        carService.deleteByPersonId(citizenDeleteDto.getId());
    }
}
