package com.jah.aplicacion_inventada.Controlador;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import com.jah.aplicacion_inventada.Modelo.FamiliaPersonaje.Enemigo;
import com.jah.aplicacion_inventada.Vista.ActivityPelea;
import com.jah.aplicacion_inventada.Vista.MainActivity;

public class ControladorEnemigo {

    public static Enemigo enemigo;

    public static Enemigo getEnemigo() {
        return enemigo;
    }

    public static void setEnemigo(Enemigo enemigo) {
        ControladorEnemigo.enemigo = enemigo;
    }

    public static void enemigo1(){
        ControladorEnemigo.setEnemigo(new Enemigo("Caballero hueco", 45, 45, 0, 0));
    }

    public static void enemigo2(){
        ControladorEnemigo.setEnemigo(new Enemigo("Caballero violeta", 55, 55, 1, 0));
    }

    public static void enemigo3(){
        ControladorEnemigo.setEnemigo(new Enemigo("Caballero agil", 65, 65, 2, 1));
    }

    public static void ataque(int danio, Context context) {
        danio += ControladorEnemigo.getEnemigo().getAtaque() - ControladorPersonaje.getPersonaje().getDefensa();
        int vidaRes = ControladorPersonaje.getPersonaje().getVida() - danio;
        Log.i("daño", "Daño recibido: " + danio);
        if(danio > ControladorPersonaje.getPersonaje().getVida()){
            ControladorPersonaje.getPersonaje().setVida(0);
            createDialogDerrota(context);
        }else if(danio < ControladorPersonaje.getPersonaje().getVida() && danio > 0){
            ControladorPersonaje.getPersonaje().setVida(vidaRes);
        }
    }

    private static void createDialogDerrota(Context context) {
        new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle("DERROTA")
                .setMessage("El enemigo te ha superado en fuerza")
                .setPositiveButton("Continuar", (dialogInterface, i) -> {
                    Intent menu = new Intent(context, MainActivity.class);
                    ActivityPelea.mediaPlayer.stop();
                    ActivityPelea.mediaPlayer.release();
                    context.startActivity(menu);
                })
                .create()
                .show();
    }
}
