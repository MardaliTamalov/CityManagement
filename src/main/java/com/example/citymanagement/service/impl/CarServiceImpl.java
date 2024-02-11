package com.example.citymanagement.service.impl;


import com.example.citymanagement.entity.Car;
import com.example.citymanagement.repository.CarRepository;
import com.example.citymanagement.service.CarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;


    @Override
    public List<Car> getAllCar() {
        return carRepository.getAllCar();
    }

    @Override
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        if (carRepository.findById(id).isPresent())
            carRepository.deleteById(id);
    }
}
