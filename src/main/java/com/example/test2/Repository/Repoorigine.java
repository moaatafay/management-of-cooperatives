package com.example.test2.Repository;

import com.example.test2.Entities.Origine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repoorigine extends JpaRepository<Origine,Long> {


    @Query("SELECT count(nom) from Origine where nom =?1 ")
    int countOrigineByNon(String name);
    @Query("SELECT id from Origine where nom=?1")
    long findOrigineByNom(String name);
}
