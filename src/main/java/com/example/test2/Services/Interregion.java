package com.example.test2.Services;


import com.example.test2.Entities.Region;

import java.util.List;

public interface Interregion {

    int countRegionByNon(String name);

    long findRegionsByNom(String name);

    Region saveregion(Region r);

    void deleteregion(Region r);

    void deleteregionById(Long id);

    Region getregionById(Long id);



    List<Region> getAllregions();



}
