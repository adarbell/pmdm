package com.example.proyectopmdm;

import java.io.Serializable;

public class Peliculas implements Serializable {
    private int id;
    private String titulo;
    private String autor;
    private int img;
    private int user_id;

    public Peliculas(int id, String titulo, String autor, int img, int user_id) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.img = img;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getUserId() {
        return user_id;
    }

    public void serUserId(int user_id) {
        this.user_id = user_id;
    }



    @Override
    public String toString() {
        return "Peliculas{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", img='" + img + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
