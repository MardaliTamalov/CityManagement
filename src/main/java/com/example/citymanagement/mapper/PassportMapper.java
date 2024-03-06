package com.example.citymanagement.mapper;

import com.example.citymanagement.dto.PassportDto;
import com.example.citymanagement.entity.Passport;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PassportMapper {
    List<PassportDto> map(List<Passport> passportList);
}
