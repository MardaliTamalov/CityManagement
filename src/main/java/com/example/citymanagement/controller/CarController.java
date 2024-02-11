package com.example.citymanagement.controller;

import com.example.citymanagement.dto.CarDto;
import com.example.citymanagement.dto.CarResponsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;




public interface CarController {

    @GetMapping
     List<CarResponsDto> getAll();

    @GetMapping("/{id}")
    CarDto getById(@PathVariable int id);

    @PostMapping
    CarDto create(@RequestBody CarDto carDto);

    @DeleteMapping
    void deleteById(int id);
}
