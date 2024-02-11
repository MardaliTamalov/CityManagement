package com.example.citymanagement.controller;

import com.example.citymanagement.dto.HouseDto;
import com.example.citymanagement.dto.HouseResponsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;




public interface HouseController {
    @GetMapping
    List<HouseResponsDto> getAll();

    @GetMapping("/{id}")
    HouseDto getById(@PathVariable int id);

    @PostMapping
    HouseDto create(@RequestBody HouseDto houseDto);

    @DeleteMapping
    void deleteById(int id);
}