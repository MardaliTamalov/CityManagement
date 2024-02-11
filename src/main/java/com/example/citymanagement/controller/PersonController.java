package com.example.citymanagement.controller;

import com.example.citymanagement.dto.PersonDto;
import com.example.citymanagement.dto.PersonResponsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface PersonController {

    @GetMapping
    List<PersonResponsDto> getAllPerson();

    @GetMapping("/{id}")
    PersonDto getById(@PathVariable int id);

    @PostMapping
    PersonDto create(@RequestBody PersonDto personDto);

    @DeleteMapping
    void deleteById(int id);
}
