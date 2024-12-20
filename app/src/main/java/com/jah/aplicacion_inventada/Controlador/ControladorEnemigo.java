package com.jah.aplicacion_inventada.Controlador;

import com.jah.aplicacion_inventada.Modelo.FamiliaPersonaje.Enemigo;
import com.jah.aplicacion_inventada.Modelo.FamiliaPersonaje.Personaje;

public class ControladorEnemigo {

    public static Enemigo enemigo;

    public static Enemigo getEnemigo() {
        return enemigo;
    }

    public static void setEnemigo(Enemigo enemigo) {
        ControladorEnemigo.enemigo = enemigo;
    }

    public static void enemigo1(){
        enemigo = new Enemigo("Caballero hueco", 45, 45, 0, 0);
    }

    public static void enemigo2(){
        enemigo = new Enemigo("Caballero violeta", 55, 55, 1, 0);
    }

    public static void enemigo3(){
        enemigo = new Enemigo("Caballero agil", 70, 70, 2, 1);
    }

    public static void ataque(int daño, Enemigo enemigo, Personaje personaje){
        daño += enemigo.getAtaque();
        int ataque = personaje.getVida() - daño;

        if(ataque <= 0){
            personaje.setVida(0);
        }else{
            personaje.setVida(ataque);
        }
    }
}
