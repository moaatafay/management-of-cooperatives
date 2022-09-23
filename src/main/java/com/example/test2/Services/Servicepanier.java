package com.example.test2.Services;

import com.example.test2.Entities.Panier;
import com.example.test2.Repository.Repoconsomme;
import com.example.test2.Repository.Repopanier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicepanier implements Interpanier{


    @Autowired
    private Repopanier repo;
    @Override
    public Panier savepanier(Panier c) {
        return repo.save(c);
    }

    @Override
    public void deletepanier(Panier c) {
        repo.delete(c);
    }

    @Override
    public void deletepanierById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Panier getpanier(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Panier> getAllpaniers() {
        return repo.findAll();
    }
}
