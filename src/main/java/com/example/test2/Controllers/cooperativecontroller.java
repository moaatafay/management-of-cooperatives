package com.example.test2.Controllers;

import com.example.test2.Entities.*;
import com.example.test2.Repository.Reporegion;
import com.example.test2.Services.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class cooperativecontroller {





    @Autowired
    private Servicecooperative service;
    @Autowired
    private Serviceregion service2;
    @Autowired
    private Servicesector service3;


    @GetMapping("/acceslibre/cooperatives/all")
    public List<Cooperative> AllCooperative(){
        return service.getAllcooperatives();
    }

    @GetMapping("/acceslibre/cooperatives/{id}")
    public Cooperative getcooperative(@PathVariable Long id){
        return service.getcooperative(id);
    }

    @PostMapping(value="/cooperative")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String savecooperative(@RequestBody Cooperative c) {
        Region region=new Region();
        Sector sector=new Sector();
        sector=c.getSector();
        region=c.getRegion();
        int cal=0;
        Long id;
        int i=service.countCooperativeByEmail(c.getEmail());
        if (i==0){
            cal= service2.countRegionByNon(c.getRegion().getNom());
            if(cal==0){
                service2.saveregion(region);
            }
            else{
                id=service2.findRegionsByNom(c.getRegion().getNom());

                c.getRegion().setId(id);

            }
            cal=service3.countSectorByNon(c.getSector().getNom());
            if(cal==0){
                service3.savesector(sector);
            }
            else{
                id= service3.findSectorsByNom(c.getSector().getNom());
                c.getSector().setId(id);
            }
            service.savecooperative(c);
            return "succesfully";
        }
        else
        {
           return "email deja exist";
        }


    }


    @PutMapping("/cooperatives/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Cooperative updatecooperative(@PathVariable("id") Long id,@RequestBody Cooperative c) {
        Cooperative  coperativerest=service.getcooperative(id);



        coperativerest.setNom(c.getNom());
        coperativerest.setEmail(c.getEmail());
        coperativerest.setPassword(c.getPassword());
        coperativerest.setAddress(c.getAddress());

        int i=service2.countRegionByNon(c.getRegion().getNom());
        if(i==0){
            service2.saveregion(c.getRegion());

        }
        else{
            Long position=service2.findRegionsByNom(c.getRegion().getNom());
            c.getRegion().setId(position);

        }
        i=service3.countSectorByNon(c.getSector().getNom());
        if(i==0){
            service3.savesector(c.getSector());

        }
        else{

            Long position2= service3.findSectorsByNom(c.getSector().getNom());
            c.getSector().setId(position2);

        }


        coperativerest.setRegion(c.getRegion());
        coperativerest.setSector(c.getSector());






        service.savecooperative(coperativerest);

        return c;
    }

    @DeleteMapping("/cooperatives/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletecooperativeById(@PathVariable("id") Long id)
    {
        Cooperative c= service.getcooperative(id);
        service.deletecooperative(c);
        return "delete";
    }

    @GetMapping("/acceslibre/cooperativebyregion/{name_region}")
    public List<Cooperative> cooperativebyregion(@PathVariable("name_region") String name_region)
    {

        return service.getCooperativeByregion(name_region);
    }
    @GetMapping("/acceslibre/cooperativebysector/{name_sector}")
    public List<Cooperative> cooperativebysector(@PathVariable("name_sector") String name_sector)
    {

        return service.getCooperativeBySector(name_sector);
    }





}
