package com.example.citymanagement.service.impl;


import com.example.citymanagement.entity.Car;
import com.example.citymanagement.repository.CarsRepository;
import com.example.citymanagement.service.CarService;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CarServiceImpl implements CarService {
    private final CarsRepository carsRepository;

    @Override
    public List<Car> getAllCar() {
        return carsRepository.getAllCar();
    }

    @Override
    public Car getById(int id) {
        return carsRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Car create(Car car) {


        return null;
    }

    ;

    @Override
    @Transactional
    public void deleteById(Long id) {

    }

}
