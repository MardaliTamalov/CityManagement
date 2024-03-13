package com.example.citymanagement.repository;

import com.example.citymanagement.entity.Passport;
import com.example.citymanagement.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(nativeQuery = true,
            value = "select * from persons where upper(surname) like upper(CONCAT(:surname,'%'))")
//    and gender like LOWER('м%')
    List<Person> findBySurname(@Param("surname") String surname);
}
