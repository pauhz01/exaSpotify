package com.example.exaspotify;

public class Cancion {
    private String foto;
    private  String titulo;
    private String cantante;

    public String getCantante() {
        return cantante;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }
}
