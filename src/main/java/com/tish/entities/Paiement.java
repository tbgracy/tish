package com.tish.entities;

import java.io.Serializable;
import java.util.Date;

public class Paiement implements Serializable {
    private static final long idUtilisateur = 1L;
    private static final long idCmd = 1L;
    private String typePaiement;
    private Double montant;
    private Date date;

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
