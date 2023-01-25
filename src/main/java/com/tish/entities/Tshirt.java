package com.tish.entities;

import java.io.Serializable;

public class Tshirt implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idTShirt;
	private String motif;
	private String couleur;
	private int nombre;
	private String taille;

	public Tshirt() {
		// empty
	};
	
	public Tshirt(String motif, String couleur, int nombre, String taille) {
		this.motif = motif;
		this.couleur = couleur;
		this.nombre = nombre;
		this.taille = taille;
	}

	public Tshirt(int idTShirt, String motif, String couleur, int nombre, String taille) {
		this.idTShirt = idTShirt;
		this.motif = motif;
		this.couleur = couleur;
		this.nombre = nombre;
		this.taille = taille;
	}

	public int getIdTShirt() {
		return idTShirt;
	}

	public void setIdTShirt(int idTShirt) {
		this.idTShirt = idTShirt;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
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
