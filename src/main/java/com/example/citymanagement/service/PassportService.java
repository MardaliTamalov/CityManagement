package com.example.citymanagement.service;

import com.example.citymanagement.entity.Passport;
import com.example.citymanagement.entity.Person;

public interface PassportService {

    Passport create(Person person);

}
