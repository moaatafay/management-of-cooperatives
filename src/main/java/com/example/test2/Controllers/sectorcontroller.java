package com.example.test2.Controllers;

import com.example.test2.Entities.Region;
import com.example.test2.Entities.Sector;
import com.example.test2.Services.Serviceregion;
import com.example.test2.Services.Servicesector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class sectorcontroller {

    @Autowired
    private Servicesector service;

    @GetMapping("/acceslibre/sector/all")
    public List<Sector> getAllsectors(){
        return service.getAllsectors();    }


    @GetMapping("/acceslibre/sector/{id}")
    public Sector getsectorById(@PathVariable Long id){
        return service.getsectorById(id);
    }


    @DeleteMapping("/acceslibre/sector/{id}")
    public void deletesectorById(@PathVariable Long id){


        service.deletesectorById(id);

    }

}
