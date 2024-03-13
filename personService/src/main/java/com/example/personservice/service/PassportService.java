package com.example.personservice.service;

import com.example.personservice.entity.Passport;
import com.example.personservice.entity.Person;

public interface PassportService {

    Passport create(Person person);

}
