package com.example.houseservice.service.impl;


import com.example.houseservice.entity.House;
import com.example.houseservice.repository.HouseRepository;
import com.example.houseservice.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Override
    public List<House> getAllHouse() {
        return houseRepository.findAll();
    }

    @Override
    public House getById(int id) {
        return houseRepository.findById(id).orElseThrow();
    }

    @Override
    public House addResident(int id) {
        return houseRepository.findHouseByPersonId(id);
    }

    @Override
    public House create(House house) {
        return houseRepository.save(house);
    }

    @Override
    public void deleteById(int id) {
        if (houseRepository.findById(id).isPresent())
            houseRepository.deleteById(id);
    }
}