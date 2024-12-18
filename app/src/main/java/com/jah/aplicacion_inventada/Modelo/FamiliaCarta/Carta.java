package com.jah.aplicacion_inventada.Modelo.FamiliaCarta;

public class Carta {

    String nombre;
    String descripcion;
    int coste;
    int imagen;

    public Carta(){}

    public Carta(String nombre, String descripcion, int coste, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.coste = coste;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", coste=" + coste +
                ", imagen=" + imagen +
                '}';
    }
}
