package com.jah.aplicacion_inventada.Vista;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.jah.aplicacion_inventada.R;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    SoundPool soundPool;
    Button btnJugar, btnCartas;
    MaterialToolbar mtbMenu;
    int sonidoCargado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        setSupportActionBar(mtbMenu);
        btnJugar.setOnClickListener(view -> jugar());
        btnCartas.setOnClickListener(view -> verCartas());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_salir){
            createDialogSalir();
        }
        return false;
    }

    private void createDialogSalir() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setNegativeButton(R.string.dialog_negative, null)
                .setPositiveButton(R.string.dialog_positive, (dialogInterface, i) -> {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finishAffinity();
                })
                .create()
                .show();
    }

    private void jugar() {
        Intent jugar = new Intent(getApplicationContext(), ActivityPrimeraPantalla.class);
        startActivity(jugar);
        mediaPlayer.stop();
        mediaPlayer.release();
        finish();
    }

    private void verCartas() {
        Intent cartas = new Intent(getApplicationContext(), ActivityVerCartas.class);
        startActivity(cartas);
    }

    private void initComponents() {
        mtbMenu = findViewById(R.id.mtbMenu);
        btnJugar = findViewById(R.id.btnJugar);
        btnCartas = findViewById(R.id.btnCartas);

        soundPool = new SoundPool.Builder().build();
        sonidoCargado = soundPool.load(getApplicationContext(), R.raw.sonido_boton, 1);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.menuprincipal);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
}