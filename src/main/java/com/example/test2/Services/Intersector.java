package com.example.test2.Services;


import com.example.test2.Entities.Sector;

import java.util.List;

public interface Intersector {

    long findSectorsByNom(String name);
    int countSectorByNon(String name);


    Sector savesector(Sector r);

    void deletesector(Sector r);

    void deletesectorById(Long id);

    Sector getsectorById(Long id);


    List<Sector> getAllsectors();
}
