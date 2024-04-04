package com.example.personservice.service.impl;

import com.example.personservice.entity.Passport;
import com.example.personservice.entity.Person;
import com.example.personservice.enums.Status;
import com.example.personservice.repository.PassportRepository;
import com.example.personservice.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    @Override
    public Passport create(Person person) {

        int seriesNumber =  new Random().ints(1000000000, Integer.MAX_VALUE)
                .boxed()
                .findFirst()
                .orElseThrow();

        Passport passport = new Passport(null, seriesNumber, LocalDate.now(),
                person, Status.ACTIVE);
       return passportRepository.save(passport);
    }
}
