package com.tish.entities;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {
    private static final long idCmd = 1L;
    private String numeroTel;
    private int nombreCmd;
    private Date dateCmd;
    private boolean etatCmd;

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
