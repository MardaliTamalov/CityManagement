package com.example.carservice.kafka;

import com.example.api.kafka.CitizenDeleteDto;
import com.example.carservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HouseDeleteConsumer {
    private final CarService carService;
    private final CarDeleteProducer carDeleteProducer;

    @KafkaListener(groupId = "HouseGroup", topics = "rollback_delete_person")
    public void rollbackDeletePersonID(CitizenDeleteDto citizenDeleteDto) {
        carService.activeByPersonId(citizenDeleteDto.getId());
        carDeleteProducer.rollbackDeleteCar(citizenDeleteDto);
    }
}
