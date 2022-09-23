package com.example.test2.Services;

import com.example.test2.Entities.Matiere;
import com.example.test2.Repository.Repomatiere;
import com.example.test2.Repository.Repoorigine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicematiere implements Intermatiere {


    @Autowired
    private Repomatiere repo;

    @Override
    public int countMatiereByNom(String name, Long i) {
        return repo.countMatiereByNom(name,i);
    }

    @Override
    public Matiere savematiere(Matiere m) {
        return repo.save(m);
    }

    @Override
    public void deletematiere(Matiere m) {
    repo.delete(m);
    }

    @Override
    public void deletematiereById(Long id) {
    repo.deleteById(id);
    }

    @Override
    public Matiere getmatiereById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Matiere> getAllmatiere() {
        return repo.findAll();
    }
}
