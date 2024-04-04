package com.example.personservice.entity;

import com.example.personservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persons")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name= "name")
    private String name;

    @Column(name= "surname")
    private String surname;

    @Column(name= "birth_date")
    private LocalDate birthDate;

    @Column(name = "gender")
    private String gender;

    @OneToOne(cascade = CascadeType.REMOVE)
  //  @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
