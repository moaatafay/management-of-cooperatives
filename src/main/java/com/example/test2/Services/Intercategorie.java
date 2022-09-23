package com.example.test2.Services;

import com.example.test2.Entities.Categorie;
import com.example.test2.Entities.Matiere;

import java.util.List;

public interface Intercategorie {


    int countCategorieByNon(String name);
    long findCategoriesByNom(String name);

    Categorie savecategorie(Categorie r);

    void deletecategorie(Categorie r);

    void deletecategorieById(Long id);

    Categorie getcategorieById(Long id);


    List<Categorie> getAllcategorie();
}
