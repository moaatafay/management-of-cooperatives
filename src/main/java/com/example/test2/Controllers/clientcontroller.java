package com.example.test2.Controllers;

import com.example.test2.Entities.Client;

import com.example.test2.Entities.Cooperative;
import com.example.test2.Services.Serviceclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class clientcontroller {



    @Autowired
    private Serviceclient service;




    public static Integer the_user_id;



    @PostMapping("/clients/sign_in")
    public void sign_in(@RequestBody Client c){
        service.saveclient(c);

        the_user_id=service.findClientByNom(c).intValue();
    }

    @GetMapping("/clients/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Client getclientById(@PathVariable Long id){
        return service.getclientById(id);
    }



  /* @PostMapping(value="/achat/{id_produit}/{quantite}")
    public void achatproduit( @PathVariable("id_produit") Long id_produit, @PathVariable("quantite") Long quantite,@RequestBody Commande c) {



        LocalDateTime datenow = LocalDateTime.now();


        c.setDate(datenow.toString());
        Produit produit= serviceproduit.getproduitById(id_produit);

        c.setProduit(produit);


        Client client=c.getClient();
        Long test=produit.getQuantite();

        if (test>=quantite){

            produit.setQuantite(test-quantite);
            serviceproduit.saveproduit(produit);

            int i=serviceclient.countClientByEmail(c.getClient().getEmail());
            if(i==0){
                serviceclient.saveclient(client);
            }
            else{

                int test2=repoclient.countClientByNom(c.getClient().getNom(),c.getClient().getNum(),c.getClient().getPrenom(),c.getClient().getEmail(),c.getClient().getAdresse());

                if(test2!=0){
                    Long j=repoclient.findClientByNom(c.getClient().getNom(),c.getClient().getNum(),c.getClient().getPrenom(),c.getClient().getEmail(),c.getClient().getAdresse());
                    client.setId(j);

                    c.getClient().setId(j);
                }
                else{
                    serviceclient.saveclient(client);
                }

            }

            servicecommande.savecommande(c);

             }






    }*/





}
