package com.jah.aplicacion_inventada.Vista;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jah.aplicacion_inventada.Controlador.ControladorEnemigo;
import com.jah.aplicacion_inventada.Controlador.ControladorPersonaje;
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Carta;
import com.jah.aplicacion_inventada.R;

import java.util.List;

public class ActivityPelea extends AppCompatActivity {

    RecyclerView rvCartas;
    LinearLayoutManager disposicion;
    AdaptadorMazo adaptadorMazo;
    ProgressBar pbVidaPj, pbVidaPnj;
    TextView lblEnergia;
    MediaPlayer mediaPlayer;
    Button btnFinTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelea);
        initComponents();
        btnFinTurno.setOnClickListener(view -> finTurno());
    }

    private void finTurno() {
        ControladorPersonaje.getPersonaje().setTurnos(3);
        ControladorEnemigo.ataque(10, ControladorEnemigo.getEnemigo(), ControladorPersonaje.getPersonaje());
        pbVidaPj.setProgress(ControladorPersonaje.getPersonaje().getVida());
        pbVidaPnj.setProgress(ControladorEnemigo.getEnemigo().getVida());
    }

    private void initComponents() {
        rvCartas = findViewById(R.id.rvCartas);
        pbVidaPj = findViewById(R.id.pbVidaPj);
        pbVidaPnj = findViewById(R.id.pbVidaPnj);
        lblEnergia = findViewById(R.id.lblEnergia);
        btnFinTurno = findViewById(R.id.btnFinTurno);
        disposicion = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCartas.setLayoutManager(disposicion);
        adaptadorMazo = new AdaptadorMazo(ControladorPersonaje.getPersonaje().getMazo());
        rvCartas.setAdapter(adaptadorMazo);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.musicajugando);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        pbVidaPj.setMax(ControladorPersonaje.getPersonaje().getVidaMaxima());
        pbVidaPj.setProgress(ControladorPersonaje.getPersonaje().getVida());
        pbVidaPnj.setMax(ControladorEnemigo.getEnemigo().getVidaMaxima());
        pbVidaPnj.setProgress(ControladorEnemigo.getEnemigo().getVida());
        String energia = ControladorPersonaje.getPersonaje().getTurnos() + "/" + ControladorPersonaje.getPersonaje().getTurnosTotales();
        lblEnergia.setText(energia);
    }
}