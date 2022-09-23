package com.example.test2.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Consomme")
public class Consomme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantite;

    @ManyToOne
    private Panier panier;
    @ManyToOne
    private Produit produit;
}
