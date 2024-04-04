package com.example.personservice.service;

import com.example.personservice.entity.Passport;
import com.example.personservice.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPerson();
    Person getById(int id);

    List<Person> getByAddress(String address);
    List<Passport> getBySurname(String surname);

    Person create(Person person);

    void deleteById(int id);
    void rollbackDeleteById(int id);

}