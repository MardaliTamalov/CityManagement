package com.example.carservice.kafka;

import com.example.api.kafka.CitizenDeleteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarDeleteProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void testSendMessage() {kafkaTemplate.send("demo", "привет мир!");
    }

public void rollbackDeleteCar(CitizenDeleteDto citizenDeleteDto){
        kafkaTemplate.send("rollback_delete_car", citizenDeleteDto);}
}
