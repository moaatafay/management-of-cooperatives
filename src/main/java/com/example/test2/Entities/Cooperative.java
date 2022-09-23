package com.example.test2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Data
    @Entity
    @Table(name="Cooperative")
    public class Cooperative {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name = "nom")
        private String nom;
        @Column(name = "email")
        private String email;
        @Column(name = "password")
        private String password;
        @Column(name= "address")
        private String address;




        @ManyToOne
        private Sector sector;

        @ManyToOne
        private Region region;
    @JsonIgnore
    @OneToMany(mappedBy = "cooperative")
    private List<Produit> produits;




    }
