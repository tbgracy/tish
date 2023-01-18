package com.tish.entities;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
	private  long idCmd;
    private String numeroTel;
    private int nombreCmd;
    private Date dateCmd;
    private boolean etatCmd;

    public Commande(long idCmd, String numeroTel, int nombreCmd, Date dateCmd, boolean etatCmd) {
        this.idCmd = idCmd;
        this.numeroTel = numeroTel;
        this.nombreCmd = nombreCmd;
        this.dateCmd = dateCmd;
        this.etatCmd = etatCmd;
    }

    public long getIdCmd() {
        return idCmd;
    }

    public void setIdCmd(long idCmd) {
        this.idCmd = idCmd;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public int getNombreCmd() {
        return nombreCmd;
    }

    public void setNombreCmd(int nombreCmd) {
        this.nombreCmd = nombreCmd;
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

