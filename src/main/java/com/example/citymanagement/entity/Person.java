package com.example.citymanagement.entity;

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

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "owner")
    private List<Car> carList;

    @ManyToMany
    @JoinTable(name = "owner_house",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id", nullable=false),
            inverseJoinColumns = @JoinColumn(name = "house_id", referencedColumnName = "id", nullable=false)
    )
    private List<House> houseList;

}
