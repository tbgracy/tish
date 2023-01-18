package com.tish.entities;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUtilisateur;
	private String nomUtilisateur;
	private String motDePasse;
	private String numeroTel;

	public User() {
	}

	public User(String nomUtilisateur, String motDePasse, String numeroTel) {
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.numeroTel = numeroTel;
	}

	public User(int idUtilisateur, String nomUtilisateur, String motDePasse, String numeroTel) {
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.numeroTel = numeroTel;
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateurL(int idUtilisateurL) {
		this.idUtilisateur = idUtilisateurL;
	}

	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilsateur) {
		this.nomUtilisateur = nomUtilsateur;
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
