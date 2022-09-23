package com.example.test2.Services;

import com.example.test2.Entities.Origine;
import com.example.test2.Entities.Region;

import java.util.List;

public interface Interorigine {


    int countOrigineByNon(String name);

    long findOrigineByNom(String name);

    Origine saveorigine(Origine r);

    void deleteorigine(Origine r);

    void deleteorigineById(Long id);

    Origine getregionById(Long id);


    List<Origine> getAllorigines();
}
