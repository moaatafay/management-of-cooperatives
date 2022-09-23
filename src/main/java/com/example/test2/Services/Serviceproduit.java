package com.example.test2.Services;


import com.example.test2.Entities.Produit;

import com.example.test2.Repository.Repoproduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Serviceproduit implements Interproduit{


    @Autowired
    private Repoproduit repo;


    @Override
    public List<Produit> getProduitByCategorie(String r) {
        return repo.getProduitByCategorie(r);
    }

    @Override
    public Produit saveproduit(Produit p) {
        return repo.save(p);
    }

    @Override
    public void deleteproduit(Produit p) {
    repo.delete(p);
    }

    @Override
    public void deleteproduitById(Long id) {
    repo.deleteById(id);
    }

    @Override
    public Produit getproduitById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Produit> getProduitByCooperative(String r) {
        return repo.getProduitByCooperative(r);

    }

    @Override
    public List<Produit> getProduitByOriginematiere(String origin) {
        return repo.getProduitByOriginematiere(origin);
    }

    @Override
    public List<Produit> getProduitBymatiere(String m) {
        return repo.getProduitBymatiere(m);
    }

    @Override
    public List<Produit> getProduitByregion(String r) {
        return repo.getProduitByregion(r);
    }

    @Override
    public List<Produit> getAllproduit() {
        return repo.findAll();
    }
}
