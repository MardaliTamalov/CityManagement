package com.example.personservice.kafka;

import com.example.api.kafka.CitizenDeleteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonDeleteProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(CitizenDeleteDto citizenDeleteDto) {
        kafkaTemplate.send("car_delete_event",citizenDeleteDto);
    }
}
