package com.tish.entities;

import java.io.Serializable;

public class Panier implements Serializable {
    private long IdPanier;
    private long idUtilisateur;
    private long idTShirt;

    public Panier(long idPanier, long idUtilisateur, long idTShirt) {
        this.IdPanier = idPanier;
        this.idUtilisateur = idUtilisateur;
        this.idTShirt = idTShirt;
    }

    public long getIdPanier() {
        return IdPanier;
    }

    public void setIdPanier(long idPanier) {
        IdPanier = idPanier;
    }

    public long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public long getIdTShirt() {
        return idTShirt;
    }

    public void setIdTShirt(long idTShirt) {
        this.idTShirt = idTShirt;
    }
}
