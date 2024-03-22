package com.example.personservice.controller;

import com.example.personservice.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface PersonController {

    @GetMapping("/person)")
    List<PersonResponsDto> getAllPerson();

    @GetMapping("/persons/{id}")
    PersonDto getById(@PathVariable int id);

    @PostMapping("/persons/address")
    List<PersonResponsDto> getByAddress(@RequestBody GetByAdddressDto address);

    @GetMapping("/persons/surname")
    List<PassportDto> getBySurname(@RequestBody GetBySurnameDto surname);

    @PostMapping("/persons")
    PersonDto create(@RequestBody PersonDto personDto);

    @DeleteMapping("/persons/{id}")
    void deleteById(int id);
}
