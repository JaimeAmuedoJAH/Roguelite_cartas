package com.jah.aplicacion_inventada.Vista;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jah.aplicacion_inventada.Controlador.ControladorEnemigo;
import com.jah.aplicacion_inventada.Controlador.ControladorPersonaje;
import com.jah.aplicacion_inventada.R;

public class ActivityPelea extends AppCompatActivity {

    RecyclerView rvCartas;
    static ImageView imgEnemigo;
    LinearLayoutManager disposicion;
    AdaptadorMazo adaptadorMazo;
    ProgressBar pbVidaPj, pbVidaPnj;
    public static TextView lblEnergia, lblDanioRealizado;
    public static MediaPlayer mediaPlayer;
    Button btnFinTurno;
    public static String energia;
    public static int combate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelea);
        initComponents();
        btnFinTurno.setOnClickListener(view -> finTurno());
    }

    private void finTurno() {
        ControladorEnemigo.ataque(6, this);
        pbVidaPj.setProgress(ControladorPersonaje.getPersonaje().getVida());
        pbVidaPnj.setProgress(ControladorEnemigo.getEnemigo().getVida());
        ControladorPersonaje.getPersonaje().setTurnos(ControladorPersonaje.getPersonaje().getTurnosTotales());
        energia = ControladorPersonaje.getPersonaje().getTurnos() + "/" + ControladorPersonaje.getPersonaje().getTurnosTotales();
        lblEnergia.setText(ActivityPelea.energia);
        ControladorPersonaje.getPersonaje().setDefensa(ControladorPersonaje.getPersonaje().getDefensa() * -1);
    }

    private void initComponents() {
        rvCartas = findViewById(R.id.rvCartas);
        pbVidaPj = findViewById(R.id.pbVidaPj);
        pbVidaPnj = findViewById(R.id.pbVidaPnj);
        lblEnergia = findViewById(R.id.lblEnergia);
        btnFinTurno = findViewById(R.id.btnFinTurno);
        imgEnemigo = findViewById(R.id.imgEnemigo);
        lblDanioRealizado = findViewById(R.id.lblDanioRealizado);
        combate = 0;
        iniciarEnemigo();
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
        energia = ControladorPersonaje.getPersonaje().getTurnos() + "/" + ControladorPersonaje.getPersonaje().getTurnosTotales();
        lblEnergia.setText(energia);
    }

    public static void iniciarEnemigo() {
        if(combate == 0){
            ControladorEnemigo.enemigo1();
        }else if(combate == 1){
            ControladorEnemigo.enemigo2();
            imgEnemigo.setImageResource(R.drawable.enemigo2);
        }else if(combate == 2){
            ControladorEnemigo.enemigo3();
            imgEnemigo.setImageResource(R.drawable.enemigo3);
        }
    }
}