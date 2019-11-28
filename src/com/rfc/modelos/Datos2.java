package com.rfc.modelos;

public class Datos2 extends Datos {
    protected String nomCom;

    public Datos2(String nomCom, String nomb, String apeP, String apeM, int dia, int mes, int anio, String x, String y, String rfc) {
        super(nomb, apeP, apeM, dia, mes, anio, x, y, rfc);
        this.nomCom = nomCom;
    }

    public void setNomCom(String nomCom) {
        this.nomCom = nomCom;
    }

    public String getNomCom() {
        return this.nomCom;
    }

}
