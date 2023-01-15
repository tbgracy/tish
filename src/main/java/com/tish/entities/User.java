package com.tish.entities;

import java.io.Serializable;

public class User implements Serializable {
    private static final long idUtilisateur = 1L;
    private String nomUtilsateur;
    private String motDePasse;
    private String numeroTel;

    public String getNomUtilsateur() {
        return nomUtilsateur;
    }

    public void setNomUtilsateur(String nomUtilsateur) {
        this.nomUtilsateur = nomUtilsateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
}
