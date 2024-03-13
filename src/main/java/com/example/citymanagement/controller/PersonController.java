package com.example.citymanagement.controller;

import com.example.citymanagement.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface PersonController {

    @GetMapping
    List<PersonResponsDto> getAllPerson();

    @GetMapping("/{id}")
    PersonDto getById(@PathVariable int id);

    @PostMapping("address")
    List<PersonResponsDto> getByAddress(@RequestBody GetByAdddressDto address);

    @GetMapping("surname")
    List<PassportDto> getBySurname(@RequestBody GetBySurnameDto surname);

    @PostMapping
    PersonDto create(@RequestBody PersonDto personDto);

    @DeleteMapping
    void deleteById(int id);
}
