package com.example.citymanagement.service.impl;

import com.example.citymanagement.entity.Passport;
import com.example.citymanagement.entity.Person;
import com.example.citymanagement.exception.PersonNotFoundException;
import com.example.citymanagement.repository.PassportRepository;
import com.example.citymanagement.repository.PersonRepository;
import com.example.citymanagement.service.PassportService;
import com.example.citymanagement.service.PersonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor

public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PassportService passportService;

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(int id) {
        return personRepository.findById(id).orElseThrow(()->new PersonNotFoundException(id));
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
        if (personRepository.findById(id).isPresent())
            personRepository.deleteById(id);
    }
}
