package com.tish.entities;

import java.io.Serializable;

public class TshirtItem implements Serializable {
    private static final long idPanier = 1L;
    private static final long idTShirt = 1L;
    private int quantite;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
