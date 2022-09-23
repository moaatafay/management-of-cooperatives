package com.example.test2.Services;

import com.example.test2.Entities.Consomme;
import com.example.test2.Repository.Repoconsomme;
import com.example.test2.Repository.Repocooperative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serviceconsomme implements Interconsomme{
    @Autowired
    private Repoconsomme repo;

    @Override
    public Consomme saveconsomme(Consomme c) {
        return repo.save(c);
    }

    @Override
    public void deleteconsomme(Consomme c) {
        repo.delete(c);
    }

    @Override
    public void deleteconsommeById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Consomme getconsomme(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Consomme> getAllconsommes() {
        return repo.findAll();
    }
}
