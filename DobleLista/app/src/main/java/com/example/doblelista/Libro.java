package com.example.doblelista;

public class Libro {
    String genero, titulo, autor;
    int foto;

    public Libro(String genero, String titulo, String autor, int foto) {
        this.genero = genero;
        this.titulo = titulo;
        this.autor = autor;
        this.foto = foto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
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

    @Override
    public String toString() {
        return "Libro{" +
                "genero='" + genero + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", foto=" + foto +
                '}';
    }
}
