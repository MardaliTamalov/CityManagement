package com.example.personservice.repository;

import com.example.personservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(nativeQuery = true,
            value = "select * from persons where upper(surname) like upper(CONCAT(:surname,'%'))")
//    and gender like LOWER('м%')
    List<Person> findBySurname(@Param("surname") String surname);
    @Modifying
    @Query(nativeQuery = true,value ="update person_service.public.persons set status = 'DELETE' where id=:personId")
    void setStatusDelete(@Param("personId") int id);

    @Modifying
    @Query(nativeQuery = true,value ="update person_service.public.persons set status = 'ACTIVE' where id=:personId")
    void setStatusActive(@Param("personId") int id);

}
