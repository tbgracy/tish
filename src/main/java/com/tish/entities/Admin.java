package com.tish.entities;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idAdmin;
    private String nomUtilisateur;
    private String motDePasse;

    public Admin() {
    }
    
    public Admin(String nomUtilisateur, String motDePasse) {
    	this.nomUtilisateur = nomUtilisateur;
    	this.motDePasse = motDePasse;
    }

    public Admin(int idAdmin,String nomUtilisateur, String motDePasse) {
    	this.idAdmin = idAdmin;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }
    
    public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idUtilisateur) {
		this.idAdmin = idUtilisateur;
	}

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}