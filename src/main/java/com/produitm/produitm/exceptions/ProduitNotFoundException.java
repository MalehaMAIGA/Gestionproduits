package com.produitm.produitm.exceptions;

public class ProduitNotFoundException extends RuntimeException{
    public ProduitNotFoundException(String message) {
        super(message);
    }
}
