package com.produitm.produitm.service;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.produitm.produitm.exceptions.ProduitNotFoundException;
import com.produitm.produitm.model.Produit;
import com.produitm.produitm.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Produit getProduitsById(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);

        if (optionalProduit.isEmpty()){
            throw new ProduitNotFoundException("Desole produit inexistant");
        }
        return optionalProduit.get();
    }

    public String deleteProduitById(long idProduit) {
        Optional<Produit> optionalProduit = produitRepository.findById(idProduit);

        if (optionalProduit.isEmpty()){
            throw new RuntimeException("Suppression impossible : PRODUIT INEXISTANT");
        }
        produitRepository.delete((optionalProduit.get()));

        return "Produit supprimé avec succès !";
    }

    public Produit editProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isEmpty()){
            throw new RuntimeException("Modification impossible : PRODUIT INEXISTANT");
        }
        Produit produitAModifier = optionalProduit.get();
        produitAModifier.setNom(produit.getNom());
        produitAModifier.setPrice(produit.getPrice());

        return produitRepository.save(produitAModifier);
    }
}
