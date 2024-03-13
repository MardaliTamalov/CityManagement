package com.example.api.carService.api.person;

import com.example.api.carService.api.GetByAdddressDto;
import com.example.api.carService.api.PassportDto;

import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface PersonController {

    @GetMapping("/persons)")
    List<PersonResponsDto> getAllPerson();

    @GetMapping("/persons/{id}")
    PersonDto getById(@PathVariable int id);

    @PostMapping("/persons/address")
    List<PersonResponsDto> getByAddress(@RequestBody GetByAdddressDto address);

    @GetMapping("/persons/surname")
    List<PassportDto> getBySurname(@RequestBody GetBySurnameDto surname);

    @PostMapping("/persons")
    PersonDto create(@RequestBody PersonDto personDto);

    @DeleteMapping("/persons")
    void deleteById(int id);
}
