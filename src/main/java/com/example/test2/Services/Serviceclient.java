package com.example.test2.Services;

import com.example.test2.Entities.Client;
import com.example.test2.Repository.Repocategorie;
import com.example.test2.Repository.Repoclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serviceclient implements Interclient {

    @Autowired
    private Repoclient repo;

    @Override
    public int countClientByEmail(String name) {
        return repo.countClientByEmail(name);
    }

    @Override
    public Client saveclient(Client c) {
        return repo.save(c);
    }

    @Override
    public void deleteclient(Client c) {
    repo.delete(c);
    }

    @Override
    public void deleteclientById(Long id) {
    repo.deleteById(id);
    }

    @Override
    public Client getclientById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Long findClientByNom(Client c) {
        return repo.findClientByNom(c.getNom(),c.getNum(),c.getPrenom(),c.getEmail(),c.getAdresse(),c.getPassword());
    }


    @Override
    public List<Client> getAllclient() {
        return repo.findAll();
    }
}
