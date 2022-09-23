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
@Table(name="Client")
public class Client {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private  String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "num")
    private String num;
    @Column(name = "pwd")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Panier> paniers;


}
