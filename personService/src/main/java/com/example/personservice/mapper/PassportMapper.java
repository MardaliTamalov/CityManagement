package com.example.personservice.mapper;

import com.example.personservice.dto.PassportDto;
import com.example.personservice.entity.Passport;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PassportMapper {
    List<PassportDto> map(List<Passport> passportList);
}
