package com.example.test2.Services;


import com.example.test2.Entities.Consomme;

import java.util.List;

public interface Interconsomme {




    Consomme saveconsomme(Consomme c);

    void deleteconsomme(Consomme c);

    void deleteconsommeById(Long id);

    Consomme getconsomme(Long id);

    List<Consomme> getAllconsommes();
}
