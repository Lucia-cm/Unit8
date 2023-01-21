package com.example.unit8;

public class Encapsulador {
    int idImagen;
    String textoTitulo;
    String textoContenido;

    public Encapsulador(int idImagen, String textoTitulo, String textoContenido) {
        this.idImagen = idImagen;
        this.textoTitulo = textoTitulo;
        this.textoContenido = textoContenido;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getTextoTitulo() {
        return textoTitulo;
    }

    public String getTextoContenido() {
        return textoContenido;
    }
}
