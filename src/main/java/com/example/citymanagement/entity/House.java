package com.example.citymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "houses")

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name= "address")
    private String adress;

    @Column(name = "area")
    private Double area;

   // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "houseList")
   @ManyToMany
   @JoinTable(name = "owner_house",
           joinColumns = @JoinColumn(name = "house_id", referencedColumnName = "id", nullable=false),
           inverseJoinColumns =  @JoinColumn(name = "person_id", referencedColumnName = "id", nullable=false)
   )
    private List<Person> personList;
}
