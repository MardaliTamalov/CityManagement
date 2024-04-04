package com.example.personservice.kafka;

import com.example.api.kafka.CitizenDeleteDto;
import com.example.personservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonDeleteConsumer {
    private final PersonService personService;

    @KafkaListener(groupId = "PersonGroup", topics = "rollback_delete_car")
    public void personRollbackDelete(CitizenDeleteDto citizenDeleteDto) {
        personService.rollbackDeleteById(citizenDeleteDto.getId());
    }
}
