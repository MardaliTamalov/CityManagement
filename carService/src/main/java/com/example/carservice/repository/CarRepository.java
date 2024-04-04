package com.example.carservice.repository;


import com.example.carservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query(value = """
            select DISTINCT c
            from Car c
            """)
    List<Car> getAllCar();

    Optional<Car> getCarById(int id);

    @Query(value = """
            select distinct c
            from Car c
            where c.id=:id
            """)
    Car getById(int id);

    Car findCarByBrand(String brand);

    Car findCarByPersonId(int id);

    void deleteAllByPersonId(int personId);

    @Modifying
    @Query(nativeQuery = true, value = "update car_service.public.cars set status = 'DELETE' where person_id=:personId")
    void setStatusDelete(@Param("personId") int personId);

    @Modifying
    @Query(nativeQuery = true, value = "update car_service.public.cars set status = 'ACTIVE' where person_id=:personId")
    void setStatusActive(@Param("personId") int personId);

}