package com.jah.aplicacion_inventada.Modelo.FamiliaPersonaje;

import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Carta;

import java.util.List;

public class Personaje {

    String nombre;
    int vida;
    int vidaMaxima;
    int ataque;
    int defensa;
    List<Carta> mazo;

    public Personaje(){}

    public Personaje(String nombre, int vida, int vidaMaxima, int ataque, int defensa, List<Carta> mazo) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.ataque = ataque;
        this.defensa = defensa;
        this.mazo = mazo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
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

    public List<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(List<Carta> mazo) {
        this.mazo = mazo;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", vidaMaxima=" + vidaMaxima +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", mazo=" + mazo +
                '}';
    }
}
