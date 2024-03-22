package com.example.personservice.service.impl;

import com.example.api.kafka.CitizenDeleteDto;
import com.example.personservice.entity.Passport;
import com.example.personservice.entity.Person;
import com.example.personservice.exception.PersonNotFoundException;
//import com.example.personservice.repository.HouseRepository;
import com.example.personservice.kafka.Producer;
import com.example.personservice.repository.PersonRepository;
import com.example.personservice.service.PassportService;
import com.example.personservice.service.PersonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PassportService passportService;
    private final Producer producer;
//    private final HouseRepository houseRepository;

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(int id) {
        return personRepository.findById(id).orElseThrow(()->new PersonNotFoundException(id));
    }

    @Override
    public List<Person> getByAddress(String address) {
//        return houseRepository.findByAddress(address).stream()
//                .flatMap(house->house.getPersonList().stream())
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    public List<Passport> getBySurname(String surname) {
        return personRepository.findBySurname(surname).stream()
                .map(Person::getPassport)
                        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Person create(Person person) {
        Person savePerson = personRepository.save(person);
        savePerson.setPassport(passportService.create(person));
        return savePerson;
    }

    @Override
    public void deleteById(int id) {
        if (personRepository.findById(id).isPresent()){
            personRepository.deleteById(id);
        producer.sendMessage(new CitizenDeleteDto(id));}
    }


}