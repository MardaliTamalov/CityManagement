package com.example.carservice.kafka;

import com.example.api.kafka.CitizenDeleteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class HouseDeleteProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendDeleteHouse(CitizenDeleteDto citizenDeleteDto) {
        kafkaTemplate.send("delete_house", citizenDeleteDto);
    }

}
