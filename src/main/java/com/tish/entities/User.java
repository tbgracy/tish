package com.tish.entities;

import java.io.Serializable;

public class User implements Serializable {
    private long idUtilisateurL;
    private String nomUtilsateur;
    private String motDePasse;
    private String numeroTel;

    public User(long idUtilisateurL, String nomUtilsateur, String motDePasse, String numeroTel) {
        this.idUtilisateurL = idUtilisateurL;
        this.nomUtilsateur = nomUtilsateur;
        this.motDePasse = motDePasse;
        this.numeroTel = numeroTel;
    }

    public long getIdUtilisateurL() {
        return idUtilisateurL;
    }

    public void setIdUtilisateurL(long idUtilisateurL) {
        this.idUtilisateurL = idUtilisateurL;
    }

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
