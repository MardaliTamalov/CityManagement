package com.example.citymanagement.controller;

import com.example.citymanagement.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")


public interface CarsController {

    @GetMapping
    public List<Car> getAll();

    @GetMapping("/{id}")
    Car getById(@PathVariable Long id);

    @PostMapping
    Car create(@RequestBody Car car);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id);


}
