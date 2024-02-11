package com.example.citymanagement.dto;

import java.time.LocalDate;

public record PersonResponsDto(int id, String name, String surname, LocalDate birthDate) {
}
