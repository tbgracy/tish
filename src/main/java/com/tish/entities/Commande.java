package com.tish.entities;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCmd;
	private int idUtilisateur;
	private Date dateCmd;
	private boolean etatCmd;

	public Commande(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Commande(int idCmd, int idUtilisateur, Date dateCmd, boolean etatCmd) {
		this.idCmd = idCmd;
		this.idUtilisateur = idUtilisateur;
		this.dateCmd = dateCmd;
		this.etatCmd = etatCmd;
	}

	public int getIdCmd() {
		return idCmd;
	}

	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int numeroTel) {
		this.idUtilisateur = numeroTel;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public boolean isEtatCmd() {
		return etatCmd;
	}

	public void setEtatCmd(boolean etatCmd) {
		this.etatCmd = etatCmd;
	}
}
