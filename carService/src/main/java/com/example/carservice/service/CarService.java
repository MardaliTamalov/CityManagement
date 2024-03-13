package com.example.carservice.service;

import com.example.carservice.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    Car getById(int id);

    Car addOwner(int id);

    Car create(Car car);

    void deleteById(int id);

}
