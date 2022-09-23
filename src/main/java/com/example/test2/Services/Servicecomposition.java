package com.example.test2.Services;

import com.example.test2.Entities.Composition;
import com.example.test2.Repository.Repocomposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicecomposition implements Intercomposition{

    @Autowired
    private Repocomposition repo;

    @Override
    public List<Long> findCompositionByproduit(Long id) {
        return repo.findCompositionByproduit(id);
    }

    @Override
    public Composition savecomposition(Composition c) {
        return repo.save(c);
    }

    @Override
    public void deletecomposition(Composition c) {
    repo.delete(c);
    }

    @Override
    public void deletecompositionById(Long id) {
        repo.deleteById(id);

    }

    @Override
    public Composition getcomposition(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Composition> getAllcompositions() {
        return repo.findAll();
    }

    @Override
    public List<Composition> findCompositionByidproduit(Long r) {
        return repo.findCompositionByidproduit(r);
    }
}
