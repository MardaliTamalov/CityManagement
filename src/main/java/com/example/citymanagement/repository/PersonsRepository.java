package com.example.citymanagement.repository;

import com.example.citymanagement.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonsRepository extends JpaRepository<Person,Integer> {
//    @Query(nativeQuery = true, value = """
//select
//from
//
//""")

}
