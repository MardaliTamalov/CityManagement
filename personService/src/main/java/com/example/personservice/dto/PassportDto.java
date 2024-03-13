package com.example.personservice.dto;

import java.time.LocalDate;

public record PassportDto(int seriesNumber, LocalDate issueDate) {
}
