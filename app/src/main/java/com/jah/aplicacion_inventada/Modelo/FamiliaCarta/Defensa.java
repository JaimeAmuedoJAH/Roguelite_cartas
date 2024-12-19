package com.jah.aplicacion_inventada.Modelo.FamiliaCarta;

public class Defensa extends Carta{

    int defensa;

    public Defensa(){}


    public Defensa(String nombre, String descripcion, int coste, int imagen, int defensa) {
        super(nombre, descripcion, coste, imagen);
        this.defensa = defensa;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public String toString() {
        return "Defensa{" +
                "defensa=" + defensa +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", coste=" + coste +
                ", imagen=" + imagen +
                '}';
    }
}
