package com.example.citymanagement.service;

import com.example.citymanagement.dto.CarDto;
import com.example.citymanagement.entity.Car;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    Car getById(int id);

    Car create(Car car);

    void deleteById(int id);

}
