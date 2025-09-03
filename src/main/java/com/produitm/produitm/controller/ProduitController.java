package com.produitm.produitm.controller;

import com.produitm.produitm.model.Produit;
import com.produitm.produitm.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    @GetMapping("/all")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit){
        return  produitService.createProduit(produit);
    }

    @GetMapping("{id}")
    public Produit getProduitById(@PathVariable Long id){
        return produitService.getProduitsById(id);
    }

    @DeleteMapping("{id}")
  public String deleteProduitById(@PathVariable("id") long idProduit){
        return produitService.deleteProduitById(idProduit);
    }
    @PutMapping("{id}")
    public Produit editProduit(@PathVariable long id,@RequestBody Produit produit){
        return produitService.editProduit(id,produit);
    }
}
