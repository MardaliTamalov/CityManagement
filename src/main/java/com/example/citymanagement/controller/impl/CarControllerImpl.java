package com.example.citymanagement.controller.impl;

import com.example.citymanagement.controller.CarsController;
import com.example.citymanagement.dto.CarDto;
import com.example.citymanagement.dto.CarResponsDto;
import com.example.citymanagement.entity.Car;
import com.example.citymanagement.service.CarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")

public class CarControllerImpl implements CarsController {
    private final CarService carService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<CarResponsDto> getAll() {
        return carService.getAllCar().stream().map(car -> new CarResponsDto(
                car.getId(),car.getBrand(),car.getModel(),car.getNumber(), car.getReleaseYear()))
                .collect(Collectors.toList());
                }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public Car getById(@PathVariable int id) {
        return carService.getById(id);
    }

    @Override
    public Car create(@RequestBody CarDto carDto){
        return null;
    }

    @Override
     public void deleteById(@PathVariable Long id) {

    }



}
