package com.jah.aplicacion_inventada.Vista;

import android.os.Bundle;
import android.widget.ProgressBar;

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
    AdaptadorCartas adaptadorCartas;
    ProgressBar pbVidaPj, pbVidaPnj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelea);
        initComponents();
    }

    private void initComponents() {
        rvCartas = findViewById(R.id.rvCartas);
        pbVidaPj = findViewById(R.id.pbVidaPj);
        pbVidaPnj = findViewById(R.id.pbVidaPnj);
        disposicion = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCartas.setLayoutManager(disposicion);
        adaptadorCartas = new AdaptadorCartas(ControladorPersonaje.getPersonaje().getMazo());
        rvCartas.setAdapter(adaptadorCartas);

        pbVidaPj.setMax(ControladorPersonaje.getPersonaje().getVidaMaxima());
        pbVidaPj.setProgress(ControladorPersonaje.getPersonaje().getVida());
    }
}