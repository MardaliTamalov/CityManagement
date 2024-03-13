package com.example.api.carService.api.person;

import java.time.LocalDate;

public record PersonDto(String name, String surname,String gender, LocalDate birthDate) {
}
