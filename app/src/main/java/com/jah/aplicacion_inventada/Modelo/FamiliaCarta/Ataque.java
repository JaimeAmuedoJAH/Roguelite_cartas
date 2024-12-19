package com.jah.aplicacion_inventada.Modelo.FamiliaCarta;

public class Ataque extends Carta{

    int ataque;

    public Ataque(){}

    public Ataque(String nombre, String descripcion, int coste, int imagen, int ataque) {
        super(nombre, descripcion, coste, imagen);
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
    public String toString() {
        return "Ataque{" +
                "ataque=" + ataque +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", coste=" + coste +
                ", imagen=" + imagen +
                '}';
    }
}
