package com.tish.entities;

import java.io.Serializable;
import java.util.Objects;

public class TshirtItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCmd;
	private int idTshirt;
	private int quantite;

	public TshirtItem() {

	}

	public TshirtItem(int idTshirt, int quantite) {
		this.idTshirt = idTshirt;
		this.quantite = quantite;
	}

	public TshirtItem(int idCmd, int idTshirt, int quantite) {
		this.idCmd = idCmd;
		this.idTshirt = idTshirt;
		this.quantite = quantite;
	}

	public int getIdCmd() {
		return idCmd;
	}

	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}

	public int getIdTshirt() {
		return idTshirt;
	}

	public void setIdTshirt(int idTshirt) {
		this.idTshirt = idTshirt;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "TshirtItem [idCmd=" + idCmd + ", idTshirt=" + idTshirt + ", quantite=" + quantite + "]";
	}
}
