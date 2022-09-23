package com.example.test2.Repository;

import com.example.test2.Entities.Categorie;
import com.example.test2.Entities.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repocategorie extends JpaRepository<Categorie,Long> {



    @Query("SELECT count(nom) from Categorie where nom =?1 ")
    int countCategorieByNon(String name);
    @Query("SELECT id from Categorie where nom=?1")
    long findCategoriesByNom(String name);
}
