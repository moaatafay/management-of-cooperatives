package com.example.test2.Services;


import com.example.test2.Entities.Client;
import com.example.test2.Entities.Produit;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Interclient {

    int countClientByEmail(String name);

    Client saveclient(Client r);

    void deleteclient(Client r);

    void deleteclientById(Long id);

    Client getclientById(Long id);

    Long findClientByNom(Client c);



    List<Client> getAllclient();
}
