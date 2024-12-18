package com.jah.aplicacion_inventada.Vista;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Carta;
import com.jah.aplicacion_inventada.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityVerCartas extends AppCompatActivity {

    RecyclerView rvCartas;
    AdaptadorCartas adaptadorCartas;
    List<Carta> listCartas;
    LinearLayoutManager disposicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cartas);
        cargarCartas();
        rvCartas = findViewById(R.id.rvCartas);
        disposicion = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCartas.setLayoutManager(disposicion);
        adaptadorCartas = new AdaptadorCartas(listCartas);
        rvCartas.setAdapter(adaptadorCartas);
    }

    private void cargarCartas() {
        listCartas = new ArrayList<>();
        listCartas.add(new Carta("Ataque", "Realiza un barrido con la espada inflingiendo daño físico al enemigo", 1, R.drawable.ataque1));
        listCartas.add(new Carta("Ataque+", "Realiza una estocada con la espada inflingiendo mayor cantidad de daño físico al enemigo que con un Ataque", 2, R.drawable.ataque2));
        listCartas.add(new Carta("Defensa", "Pone el escudo enfrente para bloquear el ataque del enemigo(Si el enemigo realiza un ataque+, seguirás recibiendo algo de daño)", 1, R.drawable.defensa1));
        listCartas.add(new Carta("Defensa+", "Alza el escudo bloqueando todo el daño recibido. No hay bloqueo más potente", 2, R.drawable.defensa2));
    }
}