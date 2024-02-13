package com.example.citymanagement.controller.impl;

import com.example.citymanagement.controller.HouseController;
import com.example.citymanagement.dto.HouseDto;
import com.example.citymanagement.dto.HouseResponsDto;
import com.example.citymanagement.mapper.HouseMapper;
import com.example.citymanagement.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/house")

public class HouseControllerImpl implements HouseController {
    private final HouseService houseService;
    private final HouseMapper houseMapper;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<HouseResponsDto> getAll() {
        return houseMapper.map(houseService.getAllHouse());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public HouseDto getById(@PathVariable int id) {
        return houseMapper.mapHouse(houseService.getById(id));
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public HouseDto create(@RequestBody HouseDto houseDto) {
        return houseMapper.mapHouse(houseService.create(houseMapper.map(houseDto)));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id) {
        houseService.deleteById(id);
    }
}
