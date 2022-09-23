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
@Table(name="Matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String nom;


    @ManyToOne
    private Origine origine;

    @JsonIgnore
    @OneToMany(mappedBy = "matiere")
    private List<Composition> compositions;


}
