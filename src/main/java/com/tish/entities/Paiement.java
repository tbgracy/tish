package com.tish.entities;

import java.io.Serializable;
import java.util.Date;

public class Paiement implements Serializable {
    private static final long serialVersionUID = 1L;
	private long idUtilisateurL;
    private long idCmd;
    private String typePaiement;
    private Double montant;
    private Date date;

    public Paiement(long idUtilisateurL, long idCmd, String typePaiement, Double montant, Date date) {
        this.idUtilisateurL = idUtilisateurL;
        this.idCmd = idCmd;
        this.typePaiement = typePaiement;
        this.montant = montant;
        this.date = date;
    }

    public long getIdUtilisateurL() {
        return idUtilisateurL;
    }

    public void setIdUtilisateurL(long idUtilisateurL) {
        this.idUtilisateurL = idUtilisateurL;
    }

    public long getIdCmd() {
        return idCmd;
    }

    public void setIdCmd(long idCmd) {
        this.idCmd = idCmd;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
