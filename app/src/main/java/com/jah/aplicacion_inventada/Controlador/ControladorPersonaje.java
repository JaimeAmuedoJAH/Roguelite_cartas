package com.jah.aplicacion_inventada.Controlador;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Ataque;
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Carta;
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Defensa;
import com.jah.aplicacion_inventada.Modelo.FamiliaPersonaje.Enemigo;
import com.jah.aplicacion_inventada.Modelo.FamiliaPersonaje.Personaje;
import com.jah.aplicacion_inventada.R;
import com.jah.aplicacion_inventada.Vista.ActivityPelea;
import com.jah.aplicacion_inventada.Vista.ActivityPrimeraPantalla;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ControladorPersonaje implements Serializable {

    public static Personaje personaje;
    public static List<Carta> mazo;

    public static Personaje getPersonaje() {
        return personaje;
    }

    public static void aumentarSaludMaxima(int vida){
        personaje.setVidaMaxima(vida);
    }

    public static void aumentarVida(int vida){
        personaje.setVida(vida);
    }

    public static void aumentarAtaque(int ataque){
        personaje.setAtaque(ataque);
    }

    public static void aumentarDefensa(int defensa){
        personaje.setDefensa(defensa);
    }

    public static void atacar(Ataque carta, Personaje personaje, Enemigo enemigo, Context context){
        int ataque = carta.getAtaque() + personaje.getAtaque() - enemigo.getDefensa();
        int danio = enemigo.getVida() - ataque;
        if(ataque > enemigo.getVida()){
            enemigo.setVida(0);
            createDialogVictoria(context);
        }else{
            ActivityPelea.lblDanioRealizado.setText(String.valueOf(ataque));
            enemigo.setVida(danio);
        }
    }

    private static void createDialogVictoria(Context context) {
        new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle(R.string.dialog_victoria_title)
                .setMessage(R.string.dialog_victoria_message)
                .setPositiveButton(R.string.dialog_victoria_positive, (dialogInterface, i) -> {
                    ActivityPelea.combate++;
                    ActivityPelea.iniciarEnemigo();
                    if(ActivityPelea.combate == 3){
                        finDelJuego(context);
                    }
                })
                .create()
                .show();
    }

    private static void finDelJuego(Context context) {
        new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle("¡VICTORIA!!!!")
                .setMessage("ENHORABUENA LOS HAS DERROTADO A TODOS!!!")
                .setPositiveButton("Volver al menu principal", (dialogInterface, i) -> {
                    Intent intent = new Intent(context, ActivityPrimeraPantalla.class);
                    ActivityPelea.mediaPlayer.stop();
                    ActivityPelea.mediaPlayer.release();
                    context.startActivity(intent);
                })
                .create()
                .show();
    }

    public static void personajeInicial(){
        personaje = new Personaje("Renegado", 70, 70, 0, 0, mazo, 3, 3);
    }

    public static void mazoInicial(){
            mazo = new ArrayList<>();
            mazo.add(new Ataque("Ataque", "Realiza un barrido con la espada inflingiendo daño físico al enemigo", 1, R.drawable.ataque1, 6));
            mazo.add(new Ataque("Ataque", "Realiza un barrido con la espada inflingiendo daño físico al enemigo", 1, R.drawable.ataque1, 6));
            mazo.add(new Ataque("Ataque", "Realiza un barrido con la espada inflingiendo daño físico al enemigo", 1, R.drawable.ataque1, 6));
            mazo.add(new Ataque("Ataque", "Realiza un barrido con la espada inflingiendo daño físico al enemigo", 1, R.drawable.ataque1, 6));
            mazo.add(new Ataque("Ataque en área", "Realiza una serie de golpes consecutivos haciendo daño a todos los enemigos de la sala", 1, R.drawable.ataque1, 4));
            mazo.add(new Ataque("Ataque+", "Realiza una estocada con la espada inflingiendo mayor cantidad de daño físico al enemigo que con un Ataque", 2, R.drawable.ataque2, 8));
            mazo.add(new Defensa("Defensa", "Pone el escudo enfrente para bloquear el ataque del enemigo(Si el enemigo realiza un ataque+, seguirás recibiendo algo de daño)", 1, R.drawable.defensa1, 5));
            mazo.add(new Defensa("Defensa", "Pone el escudo enfrente para bloquear el ataque del enemigo(Si el enemigo realiza un ataque+, seguirás recibiendo algo de daño)", 1, R.drawable.defensa1, 5));
            mazo.add(new Defensa("Defensa", "Pone el escudo enfrente para bloquear el ataque del enemigo(Si el enemigo realiza un ataque+, seguirás recibiendo algo de daño)", 1, R.drawable.defensa1, 5));
            mazo.add(new Defensa("Defensa", "Pone el escudo enfrente para bloquear el ataque del enemigo(Si el enemigo realiza un ataque+, seguirás recibiendo algo de daño)", 1, R.drawable.defensa1, 5));
            mazo.add(new Defensa("Defensa+", "Alza el escudo bloqueando todo el daño recibido. No hay bloqueo más potente", 2, R.drawable.defensa2, 7));
    }
}
