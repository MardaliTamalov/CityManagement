package com.example.houseservice.mapper;

import com.example.houseservice.dto.HouseDto;
import com.example.houseservice.dto.HouseResponsDto;
import com.example.houseservice.entity.House;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {
    List<HouseResponsDto> map(List<House> houseList);

    HouseResponsDto map(House house);

    House map(HouseDto houseDto);
    HouseDto mapHouse(House house);

}
