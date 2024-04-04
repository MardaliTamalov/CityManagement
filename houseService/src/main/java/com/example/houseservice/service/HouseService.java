package com.example.houseservice.service;

import com.example.houseservice.entity.House;
import java.util.List;

public interface HouseService {
    List<House> getAllHouse();
    House getById(int id);

    House addResident(int id);
    House create(House house);

    void deleteById(int id);
    void deleteByPersonId(int id);

}