package com.example.test2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Panier")
public class Panier {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_panier;
        private String date_de_validation_panier;
        @JsonIgnore
        @OneToMany(mappedBy = "panier")
        private List<Consomme> consommes;
        @ManyToOne
        private Client client;
    }


