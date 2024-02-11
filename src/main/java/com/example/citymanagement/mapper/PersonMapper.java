package com.example.citymanagement.mapper;

import com.example.citymanagement.dto.PersonDto;
import com.example.citymanagement.dto.PersonResponsDto;
import com.example.citymanagement.entity.Person;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    List<PersonResponsDto> map(List<Person> personList);

    PersonResponsDto map(Person person);

    Person map(PersonDto personDto);
    PersonDto mapPerson(Person person);

}
