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
@Table(name="Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     private Long id;
    @Column(name = "nom")
     private String nom;
    @Column(name = "description")
     private String description;
    @Column(name = "unite")
     private String unite;
    @Column(name = "prix")
    private Long prix;
    @Column(name = "quantite")
    private Long quantite;


    /*@OneToMany(mappedBy = "produit")
    private List<Cooperative> cooperatives;*/
    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<Consomme> consommes;

    @ManyToOne
    private Categorie categorie;


    @ManyToOne
    private Cooperative cooperative;


    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<Composition> compositions;







}
