package com.jah.aplicacion_inventada.Modelo.FamiliaPersonaje;

import android.util.Log;

import com.jah.aplicacion_inventada.Controlador.ControladorPersonaje;
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Carta;

import java.util.List;

public class Personaje {

    String nombre;
    int vida;
    int vidaMaxima;
    int ataque;
    int defensa;
    List<Carta> mazo;
    int turnosTotales;
    int turnos;

    public Personaje(){}

    public Personaje(String nombre, int vida, int vidaMaxima, int ataque, int defensa, List<Carta> mazo, int turnosTotales, int turnos) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.ataque = ataque;
        this.defensa = defensa;
        this.mazo = mazo;
        this.turnosTotales = turnosTotales;
        this.turnos = turnos;
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
        this.ataque += ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa += defensa;
    }

    public List<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(List<Carta> mazo) {
        this.mazo = mazo;
    }

    public int getTurnosTotales() {
        return turnosTotales;
    }

    public void setTurnosTotales(int turnosTotales) {
        this.turnosTotales = turnosTotales;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
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
                ", turnosTotales=" + turnosTotales +
                ", turnos=" + turnos +
                '}';
    }
}
