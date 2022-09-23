package com.example.test2.Repository;

import com.example.test2.Entities.Origine;
import com.example.test2.Entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Reposector extends JpaRepository<Sector,Long> {


    @Query("SELECT count(nom) from Sector where nom =?1 ")
    int countSectorByNon(String name);
    @Query("SELECT id from Sector where nom=?1")
    long findSectorsByNom(String name);
}
