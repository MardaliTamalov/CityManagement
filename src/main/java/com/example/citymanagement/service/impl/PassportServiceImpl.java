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
        Random random = new Random();

        int seriesNumber = IntStream.range(0, 10)
                .map(i -> random.nextInt(10))
                .sum();

        Passport passport = new Passport(null, seriesNumber, LocalDate.now(),
                person);

        return passportRepository.save(passport);
    }
}
