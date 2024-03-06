package com.example.citymanagement.controller;

import com.example.citymanagement.dto.PassportDto;
import com.example.citymanagement.dto.PersonDto;
import com.example.citymanagement.dto.PersonResponsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface PersonController {

    @GetMapping
    List<PersonResponsDto> getAllPerson();

    @GetMapping("/{id}")
    PersonDto getById(@PathVariable int id);

    @GetMapping("/{address}")
    List<PersonResponsDto> getByAddress(@PathVariable String address);

    @GetMapping("/{surname}")
    List<PassportDto> getBySurname(@PathVariable String surname);


    @PostMapping
    PersonDto create(@RequestBody PersonDto personDto);

    @DeleteMapping
    void deleteById(int id);
}
