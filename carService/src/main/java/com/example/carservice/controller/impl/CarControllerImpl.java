package com.example.carservice.controller.impl;

import com.example.carservice.controller.CarController;
import com.example.carservice.dto.CarDto;
import com.example.carservice.dto.CarResponsDto;
import com.example.carservice.mapper.CarMapper;
import com.example.carservice.service.CarService;
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
    public CarResponsDto addOwner(int id) {
        return carMapper.map(carService.addOwner(id));
    }

    @Override
    public void deleteById(@PathVariable int id) {carService.deleteById(id);
    }
}
