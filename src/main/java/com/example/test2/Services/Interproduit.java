package com.example.test2.Services;


import com.example.test2.Entities.Produit;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Interproduit {

    List<Produit> getProduitByCategorie(String r);

    Produit saveproduit(Produit r);

    void deleteproduit(Produit r);

    void deleteproduitById(Long id);

    Produit getproduitById(Long id);


    List<Produit> getProduitByCooperative( String r);

    List<Produit> getProduitByOriginematiere ( String o);

    List<Produit> getProduitBymatiere(String m);

    List<Produit> getProduitByregion(String r);


    List<Produit> getAllproduit();
}
