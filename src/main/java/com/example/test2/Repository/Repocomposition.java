package com.example.test2.Repository;

import com.example.test2.Entities.Composition;
import com.example.test2.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repocomposition extends JpaRepository<Composition,Long> {

    @Query("SELECT matiere.id from Composition where produit.id=?1 ")
    List<Long> findCompositionByproduit(Long id);

    @Query("select c from Composition as c " +
            "inner join c.produit as p " +
            "on c.produit.id = :x")
    List<Composition> findCompositionByidproduit(@Param("x") Long r);

}
