package com.tish.entities;

import java.io.Serializable;

public class TshirtItem implements Serializable {
    private long idPanier;
    private long idTShirt;
    private int quantite;

    public TshirtItem(long idPanier, long idTShirt, int quantite) {
        this.idPanier = idPanier;
        this.idTShirt = idTShirt;
        this.quantite = quantite;
    }

    public long getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(long idPanier) {
        this.idPanier = idPanier;
    }

    public long getIdTShirt() {
        return idTShirt;
    }

    public void setIdTShirt(long idTShirt) {
        this.idTShirt = idTShirt;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
