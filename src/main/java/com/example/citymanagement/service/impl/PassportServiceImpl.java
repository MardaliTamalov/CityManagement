package com.example.citymanagement.service.impl;

import com.example.citymanagement.entity.Passport;
import com.example.citymanagement.entity.Person;
import com.example.citymanagement.repository.PassportRepository;
import com.example.citymanagement.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.IntStream;

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
                person);
       return passportRepository.save(passport);
    }
}
