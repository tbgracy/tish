package com.tish.entities;

import java.io.Serializable;

public class User implements Serializable {
    private int idUtilisateur;
    private String nomUtilsateur;
    private String motDePasse;
    private String numeroTel;

    public User() {
    }

    public User(int idUtilisateur, String nomUtilsateur, String motDePasse, String numeroTel) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilsateur = nomUtilsateur;
        this.motDePasse = motDePasse;
        this.numeroTel = numeroTel;
    }

    public int getIdUtilisateur() {
        return this.idUtilisateur;
    }

    public void setIdUtilisateurL(int idUtilisateurL) {
        this.idUtilisateur = idUtilisateurL;
    }

    public String getNomUtilsateur() {
        return this.nomUtilsateur;
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
