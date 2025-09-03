package com.produitm.produitm.service;

import com.produitm.produitm.model.Produit;
import com.produitm.produitm.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepository produitRepository;

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }
}
