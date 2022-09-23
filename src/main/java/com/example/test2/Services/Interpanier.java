package com.example.test2.Services;


import com.example.test2.Entities.Panier;

import java.util.List;

public interface Interpanier {

    Panier savepanier(Panier c);

    void deletepanier(Panier c);

    void deletepanierById(Long id);

    Panier getpanier(Long id);

    List<Panier> getAllpaniers();
}
