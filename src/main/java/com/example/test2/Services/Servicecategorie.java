package com.example.test2.Services;

import com.example.test2.Entities.Categorie;

import com.example.test2.Repository.Repocategorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Servicecategorie implements Intercategorie {
    @Autowired
    private Repocategorie repo;

    @Override
    public int countCategorieByNon(String name) {
        return repo.countCategorieByNon(name);
    }

    @Override
    public long findCategoriesByNom(String name) {
        return repo.findCategoriesByNom(name);
    }

    @Override
    public Categorie savecategorie(Categorie c) {



        int cal= repo.countCategorieByNon(c.getNom());
        if(cal==0){
            return   repo.save(c);
        }
        else{
            Long position=repo.findCategoriesByNom(c.getNom());

            c.setId(position);


            return c;
        }





    }

    @Override
    public void deletecategorie(Categorie c) {
    repo.delete(c);
    }

    @Override
    public void deletecategorieById(Long id) {
    repo.deleteById(id);
    }

    @Override
    public Categorie getcategorieById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Categorie> getAllcategorie() {
        return repo.findAll();
    }
}




