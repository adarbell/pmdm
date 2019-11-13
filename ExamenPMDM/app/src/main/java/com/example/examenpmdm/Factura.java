package com.example.examenpmdm;

import java.io.Serializable;

class Factura implements Serializable  {
    private String modelo;
    private int precio_horas;
    private int extras;
    private int nDias;
    private boolean seguro;
    private int total;
    private int img;

    public Factura(String modelo, int precio_horas, int extras, int nDias, boolean seguro, int total, int img) {
        this.modelo = modelo;
        this.precio_horas = precio_horas;
        this.extras = extras;
        this.nDias = nDias;
        this.seguro = seguro;
        this.total = total;
        this.img = img;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio_horas() {
        return precio_horas;
    }

    public void setPrecio_horas(int precio_horas) {
        this.precio_horas = precio_horas;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public int getnDias() {
        return nDias;
    }

    public void setnDias(int nDias) {
        this.nDias = nDias;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "modelo='" + modelo + '\'' +
                ", precio_horas='" + precio_horas + '\'' +
                ", extras=" + extras +
                ", nDias=" + nDias +
                ", seguro=" + seguro +
                ", total=" + total +
                ", img=" + img +
                '}';
    }
}
