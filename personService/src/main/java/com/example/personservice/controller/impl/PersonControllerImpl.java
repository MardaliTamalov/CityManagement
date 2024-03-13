package com.example.personservice.controller.impl;

import com.example.personservice.controller.PersonController;
import com.example.personservice.dto.GetBySurnameDto;
import com.example.personservice.dto.GetByAdddressDto;
import com.example.personservice.dto.PassportDto;
import com.example.personservice.dto.PersonDto;
import com.example.personservice.dto.PersonResponsDto;
import com.example.personservice.mapper.PassportMapper;
import com.example.personservice.mapper.PersonMapper;
import com.example.personservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class PersonControllerImpl implements PersonController {
    private final PersonService personService;
    private final PersonMapper personMapper;
    private final PassportMapper passportMapper;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponsDto> getAllPerson() {
        return personMapper.map(personService.getAllPerson());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponsDto> getByAddress(@RequestBody GetByAdddressDto address) {
        return personMapper.map(personService.getByAddress(address.getAddress()));
    }

    @Override
    public List<PassportDto> getBySurname(GetBySurnameDto surname) {
        return passportMapper.map(personService.getBySurname(surname.surname()));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public PersonDto getById(@PathVariable int id) {
        return personMapper.mapPerson(personService.getById(id));
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto create(@RequestBody PersonDto personDto) {
        return personMapper.
                mapPerson(personService.create(personMapper.map(personDto)));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id) {
        personService.deleteById(id);
    }
}
