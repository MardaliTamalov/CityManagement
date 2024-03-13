package com.example.houseservice.controller.impl;


import com.example.houseservice.controller.HouseController;
import com.example.houseservice.dto.HouseDto;
import com.example.houseservice.dto.HouseResponsDto;
import com.example.houseservice.mapper.HouseMapper;
import com.example.houseservice.service.HouseService;
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
    public HouseResponsDto addResident(int id) {
        return houseMapper.map(houseService.addResident(id));
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
