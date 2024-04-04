package com.example.houseservice.kafka;

import com.example.api.kafka.CitizenDeleteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonDeleteProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void rollbackDeletePersonId(CitizenDeleteDto citizenDeleteDto){
        kafkaTemplate.send("rollback_delete_person",citizenDeleteDto);
    }
}
