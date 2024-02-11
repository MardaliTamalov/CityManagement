package com.example.citymanagement.mapper;

import com.example.citymanagement.dto.CarDto;
import com.example.citymanagement.dto.CarResponsDto;
import com.example.citymanagement.entity.Car;
import com.example.citymanagement.service.CarService;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    List<CarResponsDto> map(List<Car> carList);

    CarResponsDto map(Car car);

    Car map(CarDto carDto);
    CarDto mapCar(Car car);
}
