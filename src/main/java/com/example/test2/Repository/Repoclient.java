package com.example.test2.Repository;

import com.example.test2.Entities.Client;

import com.example.test2.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repoclient extends JpaRepository<Client,Long> {


    @Query("SELECT id from Client where nom =?1 and num=?2 and prenom=?3 and email=?4 and adresse=?5 and password=?6 ")
    Long findClientByNom(String name,String num,String prenom,String email,String adresse,String password);

    @Query("SELECT count(id) from Client where nom =?1 and num=?2 and prenom=?3 and email=?4 and adresse=?5 ")
   int countClientByNom(String name,String num,String prenom,String email,String adresse);

    @Query("SELECT count(nom) from Client where email =?1 ")
    int countClientByEmail(String name);







    @Query("select  id from Client where email=?1")
    int findclientByemail(String email);



}
