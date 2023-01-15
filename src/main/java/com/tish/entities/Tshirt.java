package com.tish.entities;

import java.io.Serializable;
import java.util.List;

public class Tshirt implements Serializable {
    private static final long idTShirt = 1L;
    private String motif;
    private List<String> couleur;
    private int nombre;
    private String taille;

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public List<String> getCouleur() {
        return couleur;
    }

    public void setCouleur(List<String> couleur) {
        this.couleur = couleur;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }
}
