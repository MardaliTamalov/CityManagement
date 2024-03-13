package com.example.carservice.mapper;

import com.example.carservice.dto.CarDto;
import com.example.carservice.dto.CarResponsDto;
import com.example.carservice.entity.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    List<CarResponsDto> map(List<Car> carList);

    CarResponsDto map(Car car);

    Car map(CarDto carDto);
    CarDto mapCar(Car car);
}
