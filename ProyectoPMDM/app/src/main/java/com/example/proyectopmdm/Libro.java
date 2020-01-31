package com.example.proyectopmdm;

import java.io.Serializable;

public class Libro  implements Serializable {
    private int id;
    private String titulo;
    private String autor;
    private int paginas;
    private int img;

    public Libro(int id, String titulo, String autor, int paginas, int img) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.img = img;
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

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", paginas='" + paginas + '\'' +
                ", img=" + img +
                '}';
    }
}
