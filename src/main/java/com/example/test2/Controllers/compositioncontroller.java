package com.example.test2.Controllers;

import com.example.test2.Entities.*;
import com.example.test2.Repository.Repomatiere;
import com.example.test2.Repository.Repoorigine;
import com.example.test2.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class compositioncontroller {

    @Autowired
    private Servicematiere servicematiere;
    @Autowired
    private Serviceproduit serviceproduit;
    @Autowired
    private Servicecomposition servicecomposition;




    @PostMapping(value="/composition/{id_produit}/{id_matiere}")
    @PreAuthorize("hasAuthority('composition:write')")
    public String savecooperative(@PathVariable("id_produit") Long id_produit,@PathVariable("id_matiere") Long id_matiere, @RequestBody Composition c) {

        Produit produit=serviceproduit.getproduitById(id_produit);
        Matiere matiere=servicematiere.getmatiereById(id_matiere);
        int conteur=0;

        for (int i = 0; i < servicecomposition.findCompositionByproduit(id_produit).size(); i++) {


        if(servicecomposition.findCompositionByproduit(id_produit).get(i)==id_matiere)
            conteur++;

        }
            if(conteur==0) {
                c.setMatiere(matiere);
                c.setProduit(produit);
                servicecomposition.savecomposition(c);
                return "succesfuly";
            }
            else{
                return "deja existe";
            }





    }

    @GetMapping(value="/composition/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Composition> getAllcompositions() {
        return servicecomposition.getAllcompositions();
    }

    @GetMapping(value="/composition/{id_produit}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Composition> findCompositionByproduit(@PathVariable("id_produit") Long id) {
        return servicecomposition.findCompositionByidproduit(id);
    }





}




