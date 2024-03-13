package com.example.personservice.mapper;

import com.example.personservice.dto.PersonDto;
import com.example.personservice.dto.PersonResponsDto;
import com.example.personservice.entity.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    List<PersonResponsDto> map(List<Person> personList);

    PersonResponsDto map(Person person);

    Person map(PersonDto personDto);
    PersonDto mapPerson(Person person);
}
