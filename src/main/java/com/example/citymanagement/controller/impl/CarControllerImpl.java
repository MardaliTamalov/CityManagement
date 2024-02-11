package com.example.citymanagement.controller.impl;

import com.example.citymanagement.controller.CarController;
import com.example.citymanagement.dto.CarDto;
import com.example.citymanagement.dto.CarResponsDto;
import com.example.citymanagement.mapper.CarMapper;
import com.example.citymanagement.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")

public class CarControllerImpl implements CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<CarResponsDto> getAll() {
        return carMapper.map(carService.getAllCar());

//        return carService.getAllCar().stream().map(car -> new CarResponsDto(
//                        car.getId(), car.getBrand(), car.getModel(), car.getNumber(), car.getReleaseYear()))
//                .collect(Collectors.toList());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public CarDto getById(@PathVariable int id) {
        return carMapper.mapCar(carService.getById(id));
    }

    @Override
    public CarDto create(@RequestBody CarDto carDto) {
        return carMapper.mapCar(carService.create(carMapper.map(carDto)));
    }

    @Override
    public void deleteById(@PathVariable int id) {
        carService.deleteById(id);
    }
}
