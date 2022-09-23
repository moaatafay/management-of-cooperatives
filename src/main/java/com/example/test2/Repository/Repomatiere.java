package com.example.test2.Repository;

import com.example.test2.Entities.Cooperative;
import com.example.test2.Entities.Matiere;
import com.example.test2.Entities.Origine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface Repomatiere extends JpaRepository<Matiere,Long> {


    /*@Query("SELECT count(nom) from Matiere where nom =?1 ")
    int countMatiereByNon(String name);*/
    @Query("SELECT count(id) from Matiere where nom=?1 and origine.id=?2")
    int countMatiereByNom(String name,Long i);
    @Query("SELECT id from Matiere where nom=?1")
    long findMatiereByNom(String name);



}

