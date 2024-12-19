package com.jah.aplicacion_inventada.Modelo.FamiliaPersonaje;

import java.io.Serializable;

public class Enemigo implements Serializable {

    private String nombre;
    private int vidaMaxima;
    private int vida;
    private int ataque;
    private int defensa;

    public Enemigo(){}

    public Enemigo(String nombre, int vidaMaxima, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public String toString() {
        return "Enemigo{" +
                "nombre='" + nombre + '\'' +
                ", vidaMaxima=" + vidaMaxima +
                ", vida=" + vida +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                '}';
    }
}
