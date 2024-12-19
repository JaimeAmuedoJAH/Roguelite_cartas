package com.jah.aplicacion_inventada.Vista;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.jah.aplicacion_inventada.Controlador.ControladorPersonaje;
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Ataque;
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Carta;
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Defensa;
import com.jah.aplicacion_inventada.Modelo.FamiliaPersonaje.Personaje;
import com.jah.aplicacion_inventada.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityPrimeraPantalla extends AppCompatActivity {

    Button btnEleccion1, btnEleccion2, btnEleccion3;
    MediaPlayer mediaPlayer;
    SoundPool soundPool;
    int sonidoCargado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);
        initComponents();

        btnEleccion1.setOnClickListener(view -> {
            soundPool.play(sonidoCargado, 1, 1, 0, 0, 1);
            aumentarEstadistica(1);
        });
        btnEleccion1.setOnClickListener(view -> {
            soundPool.play(sonidoCargado, 1, 1, 0, 0, 1);
            aumentarEstadistica(2);
        });
        btnEleccion1.setOnClickListener(view ->  {
            soundPool.play(sonidoCargado, 1, 1, 0, 0, 1);
            aumentarEstadistica(3);
        });
    }

    private void aumentarEstadistica(int seleccion) {
        if(seleccion == 1){
            ControladorPersonaje.aumentarSaludMaxima(7);
            ControladorPersonaje.aumentarVida(7);
        }else if(seleccion == 2){
            ControladorPersonaje.aumentarAtaque(1);
        }else{
            ControladorPersonaje.aumentarDefensa(1);
        }
        Intent empezarJuego = new Intent(getApplicationContext(), ActivityPelea.class);
        mediaPlayer.stop();
        mediaPlayer.release();
        startActivity(empezarJuego);
        finish();
    }

    private void initComponents() {
        btnEleccion1 = findViewById(R.id.btnEleccion1);
        btnEleccion2 = findViewById(R.id.btnEleccion2);
        btnEleccion3 = findViewById(R.id.btnEleccion3);
        ControladorPersonaje.mazoInicial();
        ControladorPersonaje.personajeInicial();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.musicajugando);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        soundPool = new SoundPool.Builder().build();
        sonidoCargado = soundPool.load(getApplicationContext(), R.raw.sonido_boton, 1);
    }
}