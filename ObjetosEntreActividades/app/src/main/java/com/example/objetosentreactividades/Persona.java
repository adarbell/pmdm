package com.example.objetosentreactividades;

import java.io.Serializable;

class Persona implements Serializable {
    String nombre, apellido;
    int edad, foto;


    public Persona(String nombre, String apellido, int edad, int foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad=edad;
        this.foto=foto;
    }

    @Override
    public String toString() {
        return nombre + ' ' + apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad (int num){
        edad=num;
    }

    public int getFoto() {
        return foto;
    }

}

