package com.example.test2.Controllers;

import com.example.test2.Entities.Categorie;
import com.example.test2.Entities.Sector;
import com.example.test2.Services.Servicecategorie;
import com.example.test2.Services.Servicesector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class categoriecontroller {


    @Autowired
    private Servicecategorie service;

    @GetMapping("/acceslibre/categorie/all")
    public List<Categorie> getAllcategorie(){
        return service.getAllcategorie();    }


    @GetMapping("/acceslibre/categorie/{id}")
    public Categorie getcategorieById(@PathVariable Long id){
        return service.getcategorieById(id);
    }


    @DeleteMapping("/acceslibre/categorie/{id}")
    public void deletecategorieById(@PathVariable Long id){


        service.deletecategorieById(id);

    }
}
