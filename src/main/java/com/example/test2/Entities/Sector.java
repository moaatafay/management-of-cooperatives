package com.example.test2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name="sector")
public class Sector {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String nom;
    @JsonIgnore
    @OneToMany(mappedBy = "sector")
    private List<Cooperative> cooperatives;



}
