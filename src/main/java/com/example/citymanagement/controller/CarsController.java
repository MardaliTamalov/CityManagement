package com.example.citymanagement.controller;

import com.example.citymanagement.dto.CarDto;
import com.example.citymanagement.dto.CarResponsDto;
import com.example.citymanagement.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;




public interface CarsController {

    @GetMapping
     List<CarResponsDto> getAll();

    @GetMapping("/{id}")
    Car getById(@PathVariable int id);

    @PostMapping
    Car create(@RequestBody CarDto carDto);

    @DeleteMapping
    void deleteById(Long id);
}
