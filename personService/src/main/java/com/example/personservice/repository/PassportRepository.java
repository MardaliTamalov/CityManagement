package com.example.personservice.repository;

import com.example.personservice.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Integer> {
}
