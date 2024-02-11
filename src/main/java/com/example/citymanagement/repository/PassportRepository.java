package com.example.citymanagement.repository;

import com.example.citymanagement.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Integer> {
}
