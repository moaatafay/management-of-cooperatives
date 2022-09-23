package com.example.test2.Repository;

import com.example.test2.Entities.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repocooperative extends JpaRepository<Cooperative,Long> {



    @Query("SELECT count(nom) from Cooperative where email =?1 ")
    int countCooperativeByEmail(String name);

    @Query("SELECT id from Cooperative where nom=?1")
    long findCooperativeByNom(String name);



    @Query("select c from Cooperative as c " +
            "inner join c.region as r " +
            "on c.region.nom = :x")
    public List<Cooperative> getCooperativeByregion(@Param("x") String r);


    @Query("select c from Cooperative as c " +
            "inner join c.sector as s " +
            "on c.sector.nom = :x")
    public List<Cooperative> getCooperativeBySector(@Param("x") String r);


}
