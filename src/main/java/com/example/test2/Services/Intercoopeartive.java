package com.example.test2.Services;

import com.example.test2.Entities.Cooperative;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Intercoopeartive {

  int countCooperativeByEmail(String name);
  List<Cooperative> getCooperativeBySector( String r);

  List<Cooperative> getCooperativeByregion( String r);

    Cooperative savecooperative(Cooperative c);

    void deletecooperative(Cooperative c);

    void deletecooperativeById(Long id);

    Cooperative getcooperative(Long id);

    List<Cooperative> getAllcooperatives();



}
