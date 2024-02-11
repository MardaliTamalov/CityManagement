package com.example.citymanagement.service;

import com.example.citymanagement.entity.House;

import java.util.List;

public interface HouseService {
    List<House> getAllHouse();
    House getById(int id);

    House create(House house);

    void deleteById(int id);

}