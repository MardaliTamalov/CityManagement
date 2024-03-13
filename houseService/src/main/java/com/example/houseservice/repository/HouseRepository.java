package com.example.houseservice.repository;


import com.example.houseservice.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  HouseRepository extends JpaRepository<House, Integer> {
    @Query(value = "select DISTINCT h from House h WHERE LOWER(h.adress) = LOWER(:address)")
    List<House> findByAddress(@Param("address") String address);

    House findHouseByPersonId(int id);

//    @Query(
//            value = "SELECT DISTINCT * FROM houses WHERE LOWER(address) = LOWER(:address)",
//            nativeQuery = true)
//    List<Person> findByAddress(@Param("address") String address);
}
