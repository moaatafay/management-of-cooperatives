package com.example.test2.Controllers;


import com.example.test2.Entities.Matiere;
import com.example.test2.Entities.Origine;

import com.example.test2.Services.Servicematiere;
import com.example.test2.Services.Serviceorigine;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class matierecontroller {

    @Autowired
    private Serviceorigine serviceorigine  ;
    @Autowired
    private Servicematiere servicematiere     ;


    @PostMapping("/matiere/add")
    @PreAuthorize("hasAuthority('matiere:write')")
    public void addmatiere( @RequestBody Matiere matiere){
        Origine origine=matiere.getOrigine();

        int cal= serviceorigine.countOrigineByNon(origine.getNom());
        if(cal==0){
            serviceorigine.saveorigine(origine);
            servicematiere.savematiere(matiere);
            System.out.println("MAKAYNCH ORIGIN");
        }

        else{
            Long  position=serviceorigine.findOrigineByNom(origine.getNom());
            matiere.getOrigine().setId(position);
            int i=servicematiere.countMatiereByNom(matiere.getNom(), position);
            if(i==0){
                servicematiere.savematiere(matiere);
                System.out.println("KAYNA ORIGIN MAIS MATIERE MAKAYNACH");
            }
            else {

                System.out.println("KAYNA ORIGIN ET MATIERE KAYNA");
            }


        }






    }


}
