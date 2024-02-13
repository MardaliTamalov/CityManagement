package com.example.citymanagement.controller.impl;

import com.example.citymanagement.controller.PersonController;
import com.example.citymanagement.dto.PersonDto;
import com.example.citymanagement.dto.PersonResponsDto;
import com.example.citymanagement.mapper.PersonMapper;
import com.example.citymanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor

public class PersonControllerImpl implements PersonController {
    private final PersonService personService;
    private final PersonMapper personMapper;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponsDto> getAllPerson() {
        return personMapper.map(personService.getAllPerson());
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
