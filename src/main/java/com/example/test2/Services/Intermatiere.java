package com.example.test2.Services;

import com.example.test2.Entities.Matiere;


import java.util.List;

public interface Intermatiere {

    int countMatiereByNom(String name,Long i);

    Matiere savematiere(Matiere r);

    void deletematiere(Matiere r);

    void deletematiereById(Long id);

    Matiere getmatiereById(Long id);


    List<Matiere> getAllmatiere();
}
