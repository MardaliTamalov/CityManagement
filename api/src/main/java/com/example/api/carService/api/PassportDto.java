package com.example.api.carService.api;

import java.time.LocalDate;

public record PassportDto(int seriesNumber, LocalDate issueDate) {
}
