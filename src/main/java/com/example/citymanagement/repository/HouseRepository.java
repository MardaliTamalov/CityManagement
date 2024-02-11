package com.example.citymanagement.repository;

import com.example.citymanagement.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House,Integer> {

}
