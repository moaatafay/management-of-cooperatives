package com.example.test2.Services;
import com.example.test2.Entities.Region;

import com.example.test2.Repository.Reporegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serviceregion implements Interregion{

    @Autowired
    private Reporegion repo;


    @Override
    public int countRegionByNon(String name) {
        return repo.countRegionByNon(name);
    }

    @Override
    public long findRegionsByNom(String name) {
        return repo.findRegionsByNom(name);
    }

    @Override
    public Region saveregion(Region r) {
        return repo.save(r);


    }

    @Override
    public void deleteregion(Region r) {
        repo.delete(r);

    }

    @Override
    public void deleteregionById(Long id) {
        repo.deleteById(id);

    }

    @Override
    public Region getregionById(Long id) {
        return repo.findById(id).get();
    }




    @Override
    public List<Region> getAllregions() {
        return  repo.findAll();
    }
}
