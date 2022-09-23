package com.example.test2.Controllers;

import com.example.test2.Entities.Consomme;
import com.example.test2.Entities.Panier;
import com.example.test2.Entities.Produit;
import com.example.test2.Services.Serviceclient;
import com.example.test2.Services.Serviceconsomme;
import com.example.test2.Services.Servicepanier;
import com.example.test2.Services.Serviceproduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;




@RestController
public class consommeController {

    @Autowired
    private Serviceproduit serviceproduit;
    @Autowired
    private Serviceclient serviceclient;
    @Autowired
    private Servicepanier servicepanier;
    @Autowired
    private Serviceconsomme serviceconsomme ;

    private List<Consomme> ListConsommer=new ArrayList<>();


    @PostMapping("/acceslibre/achat/{idp}/{Qte}")
    public List<Consomme> ConsomerProduit(@PathVariable Long idp, @PathVariable long    Qte) throws Exception {

        Produit produit= serviceproduit.getproduitById(idp);
        Long test=produit.getQuantite();

        if (test>=Qte){

        Consomme c=new Consomme(null,Qte,null,produit);
        this.ListConsommer.add(c);
       }
        /*else
        {
            throw new Exception("pas d'assez de quantité");
        }*/
        return this.ListConsommer;
    }
    @PostMapping("/valider/{idclient}")
    @PreAuthorize("hasRole('ROLE_Client')")
    public String valider(@PathVariable Long idclient){
        if (this.ListConsommer  .isEmpty()){
            return "le panier est vide";
        }
        else{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Panier p=new Panier(null,dtf.format(now),this.ListConsommer,serviceclient.getclientById(idclient));
            servicepanier.savepanier(p);
            for(int i=0;i<this.ListConsommer.size();i++){



                Produit produit= serviceproduit.getproduitById(this.ListConsommer.get(i).getProduit().getId());
                produit.setQuantite(produit.getQuantite()-this.ListConsommer.get(i).getQuantite());
                serviceproduit.saveproduit(produit);

                this.ListConsommer.get(i).setPanier(p);
                serviceconsomme.saveconsomme(this.ListConsommer.get(i));





            }
            this.ListConsommer.clear();
            return "valider";
        }

    }


}
