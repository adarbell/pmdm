package com.example.examenpmdm;

import java.io.Serializable;

class MedioTransporte  implements Serializable  {
    private String tipo;
    private String modelo;
    private String precio;
    private int img;

    public MedioTransporte(String tipo, String modelo, String precio, int img) {
        this.tipo = tipo;
        this.modelo = modelo;
        this.precio = precio;
        this.img = img;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTipo() {
        return tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public int getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "MedioTransporte{" +
                "tipo='" + tipo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio='" + precio + '\'' +
                ", img=" + img +
                '}';
    }
}
