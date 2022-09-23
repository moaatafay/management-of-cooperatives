package com.example.test2.Services;

import com.example.test2.Entities.Composition;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface Intercomposition {
    List<Long> findCompositionByproduit(Long id);


    Composition savecomposition(Composition c);

    void deletecomposition(Composition c);

    void deletecompositionById(Long id);

    Composition getcomposition(Long id);

    List<Composition> getAllcompositions();

    List<Composition> findCompositionByidproduit(Long r);

}
