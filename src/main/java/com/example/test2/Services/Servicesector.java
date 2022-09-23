package com.example.test2.Services;

import com.example.test2.Entities.Sector;
import com.example.test2.Repository.Reporegion;
import com.example.test2.Repository.Reposector;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Servicesector implements Intersector {
    @Autowired
    private Reposector repo;

    @Override
    public long findSectorsByNom(String name) {
        return repo.findSectorsByNom(name);
    }

    @Override
    public int countSectorByNon(String name) {
        return repo.countSectorByNon(name);
    }

    @Override
    public Sector savesector(Sector s) {
        return repo.save(s);
    }

    @Override
    public void deletesector(Sector s) {
        repo.delete(s);
    }

    @Override
    public void deletesectorById(Long id) {
            repo.deleteById(id);
    }

    @Override
    public Sector getsectorById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Sector> getAllsectors() {
        return repo.findAll();
    }
}
