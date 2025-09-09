package com.produitm.produitm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name ="produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private double price;

   @ManyToMany
   @JoinTable(
           name= "product_category",
           joinColumns = @JoinColumn(name ="produit_id"),
           inverseJoinColumns = @JoinColumn(name = "category_id")
   )
    private List<Category> categoryList;
}
