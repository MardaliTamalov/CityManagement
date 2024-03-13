package com.example.houseservice.controller;

import com.example.houseservice.dto.HouseDto;
import com.example.houseservice.dto.HouseResponsDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface HouseController {
    @GetMapping
    List<HouseResponsDto> getAll();

    @GetMapping("/{id}")
    HouseDto getById(@PathVariable int id);

    @PutMapping("/addResident/{id}")
    HouseResponsDto addResident(@PathVariable int id);

    @PostMapping
    HouseDto create(@RequestBody HouseDto houseDto);

    @DeleteMapping
    void deleteById(int id);
}