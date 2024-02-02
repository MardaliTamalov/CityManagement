package com.example.citymanagement.repository;

import com.example.citymanagement.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarsRepository extends JpaRepository<Car,Integer> {
//    @Query(value = """
//
//""")

}
