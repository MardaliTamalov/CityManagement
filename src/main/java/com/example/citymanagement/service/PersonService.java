package com.example.citymanagement.service;

import com.example.citymanagement.entity.Car;
import com.example.citymanagement.entity.Passport;
import com.example.citymanagement.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPerson();
    Person getById(int id);

    List<Person> getByAddress(String address);
    List<Passport> getBySurname(String surname);

    Person create(Person person);

    void deleteById(int id);

}