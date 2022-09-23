package com.example.test2.Controllers;

import com.example.test2.Entities.*;
import com.example.test2.Services.Servicecategorie;
import com.example.test2.Services.Servicecooperative;
import com.example.test2.Services.Serviceproduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class produitcontroller {


    @Autowired
    private Serviceproduit service;

    @Autowired
    private Servicecooperative servicecooperative;

    @Autowired
    private Servicecategorie servicecategorie ;


    public static Integer the_user_id;

    @PostMapping("/produits/add/{id_cooperative}")
    @PreAuthorize("hasAuthority('produit:write')")
    public Produit addproduit(@PathVariable("id_cooperative") Long id_cooperative, @RequestBody Produit produit){
        servicecategorie.savecategorie(produit.getCategorie());
        Cooperative cooperative= servicecooperative.getcooperative(id_cooperative);
        produit.setCooperative(cooperative);
           service.saveproduit(produit);


        return  produit;
    }





    @GetMapping("/acceslibre/produits/all")
    @PreAuthorize("hasRole('ROLE_Client')")
    public List<Produit> Allproduit(){
        return service.getAllproduit();
    }

    @GetMapping("/acceslibre/produits/{id}")
    public Produit getproduitbyid(@PathVariable Long id){
        return service.getproduitById(id);
    }


    @GetMapping("/acceslibre/produits/cooperatives/{cooperative_name}")
    public  List<Produit> getProduitByCooperative(@PathVariable String cooperative_name){
        return service.getProduitByCooperative(cooperative_name);
    }



    @DeleteMapping("/produit/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_Coperative')")
    public String deleteproduitById(@PathVariable("id") Long id)
    {
        service.deleteproduitById(id);
        return "delete";
    }

    @GetMapping("/acceslibre/produitbycategorie/{name_categorie}")
    public List<Produit> produitbycategorie(@PathVariable("name_categorie") String name_categorie)
    {

        return service.getProduitByCategorie(name_categorie);
    }

    @GetMapping("/acceslibre/produitbyori/{no}")
    public List<Produit>  getProduitByOriginematiere(@PathVariable("no") String no){
        return service.getProduitByOriginematiere(no);
    }

    @GetMapping("/acceslibre/produitbymatiere/{ma}")
    public List<Produit>  getProduitBymatiere(@PathVariable("ma") String ma){
        return service.getProduitBymatiere(ma);
    }

    @GetMapping("/acceslibre/produitbyregion/{re}")
    public List<Produit>  getProduitByregion(@PathVariable("re") String re){
        return service.getProduitByregion(re);
    }






}
