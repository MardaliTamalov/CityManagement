package com.example.carservice.entity;

import com.example.carservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "number")
    private String number;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "person_id")
    private int personId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
