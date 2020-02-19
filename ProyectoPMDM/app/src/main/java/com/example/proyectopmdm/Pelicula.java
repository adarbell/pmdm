package com.example.proyectopmdm;

import java.io.Serializable;

public class Pelicula  implements Serializable {
    private int id;
    private String titulo;
    private String autor;
    private String sinopsis;
    private int user_id;

    public Pelicula(int id, String titulo, String autor, String sinopsis, int user_id) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.user_id = user_id;
    }

    public int getId() { return id; }

    public void setId() { this.id = id; }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getUserId() {
        return user_id;
    }

    public void serUserId(int user_id) {
        this.user_id = user_id;
    }



    @Override
    public String toString() {
        return "Pelicula{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}