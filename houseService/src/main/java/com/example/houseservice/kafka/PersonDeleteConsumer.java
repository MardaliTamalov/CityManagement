package com.example.houseservice.kafka;

import com.example.api.kafka.CitizenDeleteDto;
import com.example.houseservice.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonDeleteConsumer {
    private final HouseService houseService;

    @KafkaListener(groupId = "HouseGroup", topics = "delete_house")
    public void houseDelete(CitizenDeleteDto citizenDeleteDto) {
        houseService.deleteByPersonId(citizenDeleteDto.getId());
    }
}
