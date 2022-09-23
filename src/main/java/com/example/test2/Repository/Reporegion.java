package com.example.test2.Repository;


import com.example.test2.Entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Reporegion extends JpaRepository<Region,Long> {

  @Query("SELECT count(nom) from Region where nom =?1 ")
  int countRegionByNon(String name);
  @Query("SELECT id from Region where nom=?1")
  long findRegionsByNom(String name);
}
