package com.example.test2.Repository;


import com.example.test2.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repoproduit extends JpaRepository<Produit,Long> {

    @Query("select p from Produit as p " +
            "inner join p.categorie as c " +
            "on p.categorie.nom = :x")
    public List<Produit> getProduitByCategorie(String x);



    @Query("select c.produit from Composition as c inner join c.matiere as cm on c.matiere.origine.nom=:o")
    public List<Produit> getProduitByOriginematiere (@Param("o") String o);



    @Query("select p from Produit as p " +
            "inner join p.cooperative as r " +
            "on p.cooperative.nom = :x")
    public List<Produit> getProduitByCooperative(@Param("x") String r);


    @Query("select p from Produit p inner join p.compositions as c on c.matiere.nom=:m")
    public List<Produit> getProduitBymatiere(@Param("m") String m);


    @Query("select p from Produit p " +
            "inner join p.cooperative as pc " +
            "on pc.region.nom =:r")
    public List<Produit> getProduitByregion(@Param("r") String r);



}
