package com.example.houseservice.repository;


import com.example.houseservice.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Integer> {
    @Query(value = "select DISTINCT h from House h WHERE LOWER(h.adress) = LOWER(:address)")
    List<House> findByAddress(@Param("address") String address);

    @Query(nativeQuery = true, value = "select * from house_service.public.houses h join house_service.public.owner_house o on h.id= o.house_id where o.person_id =:id")
    House findHouseByPersonId(@Param("id") int id);

//    @Query(
//            value = "SELECT DISTINCT * FROM houses WHERE LOWER(address) = LOWER(:address)",
//            nativeQuery = true)
//    List<Person> findByAddress(@Param("address") String address);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM owner_house WHERE person_id=:person ")
    void deleteByPersonId(@Param("person") int person);

}
