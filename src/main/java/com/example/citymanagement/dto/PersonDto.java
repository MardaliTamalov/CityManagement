package com.example.citymanagement.dto;

import java.time.LocalDate;

public record PersonDto(String name, String surname,String gender, LocalDate birthDate) {
}
