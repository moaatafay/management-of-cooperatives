package com.example.test2.Controllers;

import com.example.test2.Entities.Produit;
import com.example.test2.Entities.Region;

import com.example.test2.Services.Serviceregion;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class regioncontroller {


    @Autowired
    private Serviceregion service;


    @GetMapping("/acceslibre/region/all")
    public List<Region> Allregions(){
        return service.getAllregions();    }


    @GetMapping("/acceslibre/region/{id}")
    public Region getregionById(@PathVariable Long id){
        return service.getregionById(id);
    }


    @DeleteMapping("/acceslibre/regiondelete/{id}")
    public void deleteregionById(@PathVariable Long id){
        System.out.println(id);

         service.deleteregionById(id);

    }






}
