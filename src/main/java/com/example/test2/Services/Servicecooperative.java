package com.example.test2.Services;

import com.example.test2.Entities.Cooperative;
import com.example.test2.Repository.Repocooperative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Servicecooperative implements Intercoopeartive {
    @Autowired
    private Repocooperative repo;


    @Override
    public int countCooperativeByEmail(String name) {
        return repo.countCooperativeByEmail(name);
    }

    @Override
    public List<Cooperative> getCooperativeBySector(String r) {
        return repo.getCooperativeBySector(r);
    }

    @Override
    public List<Cooperative> getCooperativeByregion(String r) {
        return repo.getCooperativeByregion(r);
    }

    @Override
    public Cooperative savecooperative(Cooperative c) {
        return repo.save(c) ;
    }

    @Override
    public void deletecooperative(Cooperative c) {
    repo.delete(c);
    }

    @Override
    public void deletecooperativeById(Long id) {

            repo.deleteById(id);
        }



    @Override
    public Cooperative getcooperative(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Cooperative> getAllcooperatives() {
        return  repo.findAll();
    }
}
