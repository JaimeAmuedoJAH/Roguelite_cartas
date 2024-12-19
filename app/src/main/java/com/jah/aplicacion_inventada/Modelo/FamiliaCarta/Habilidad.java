package com.jah.aplicacion_inventada.Modelo.FamiliaCarta;

public class Habilidad extends Carta{

    int habilidad;

    public Habilidad(){}

    public Habilidad(String nombre, String descripcion, int coste, int imagen, int habilidad) {
        super(nombre, descripcion, coste, imagen);
        this.habilidad = habilidad;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "habilidad=" + habilidad +
                ", descripcion='" + descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", coste=" + coste +
                ", imagen=" + imagen +
                '}';
    }
}
