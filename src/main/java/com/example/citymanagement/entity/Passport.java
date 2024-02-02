package com.example.citymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "passport")

public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "series_number")
    private int seriesNumber;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "passport")
     private Person person;

}
