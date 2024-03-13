package com.example.carservice.controller;

import com.example.carservice.dto.CarDto;
import com.example.carservice.dto.CarResponsDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface CarController {

    @GetMapping
     List<CarResponsDto> getAll();

    @GetMapping("/{id}")
    CarDto getById(@PathVariable int id);

    @PostMapping
    CarDto create(@RequestBody CarDto carDto);

    @PutMapping("/addOwner/{id}")
    CarResponsDto addOwner(@PathVariable int id);

    @DeleteMapping
    void deleteById(int id);
}
