package com.example.test2.Services;

import com.example.test2.Entities.Origine;
import com.example.test2.Repository.Repoorigine;
import com.example.test2.Repository.Reposector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serviceorigine implements Interorigine{



    @Autowired
    private Repoorigine repo;

    @Override
    public int countOrigineByNon(String name) {
        return repo.countOrigineByNon(name);
    }

    @Override
    public long findOrigineByNom(String name) {
        return repo.findOrigineByNom(name);
    }

    @Override
    public Origine saveorigine(Origine o) {
        return repo.save(o);
    }

    @Override
    public void deleteorigine(Origine o) {
    repo.delete(o);
    }

    @Override
    public void deleteorigineById(Long id) {
    repo.deleteById(id);
    }

    @Override
    public Origine getregionById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Origine> getAllorigines() {
        return repo.findAll();
    }
}
