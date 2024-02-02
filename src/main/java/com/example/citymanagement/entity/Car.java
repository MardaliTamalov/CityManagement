package com.example.citymanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
     private Person owner;
}
