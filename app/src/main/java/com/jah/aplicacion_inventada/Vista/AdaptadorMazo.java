package com.jah.aplicacion_inventada.Vista;

import android.content.Context;
import android.media.SoundPool;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.jah.aplicacion_inventada.Controlador.ControladorEnemigo;
import com.jah.aplicacion_inventada.Controlador.ControladorPersonaje;
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Ataque;
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Carta;
import com.jah.aplicacion_inventada.R;

import java.util.List;

public class AdaptadorMazo extends RecyclerView.Adapter<AdaptadorMazo.HolderMazo> {

    List<Carta> dataSet;
    Context context;
    Carta c;
    SoundPool soundPool;
    int sonidoCargado;

    public AdaptadorMazo(List<Carta> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public AdaptadorMazo.HolderMazo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        soundPool = new SoundPool.Builder().build();
        sonidoCargado = soundPool.load(context, R.raw.sonido_espada, 1);
        View view = LayoutInflater.from(context).inflate(R.layout.mazo, parent, false);
        return new HolderMazo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorMazo.HolderMazo holder, int position) {
        c = dataSet.get(position);

        holder.imgFotoCarta.setImageResource(c.getImagen());
        holder.lblNombreCarta.setText(c.getNombre());
        holder.lblDescripcionCarta.setText(c.getDescripcion());
        holder.imgCosteCarta.setText(String.valueOf(c.getCoste()));
        holder.cvCarta.setOnClickListener(view -> jugarCarta(dataSet.get(holder.getAdapterPosition())));
    }

    private void jugarCarta(Carta carta) {
        soundPool.play(sonidoCargado, 1, 1, 0, 0, 1);
        if(ControladorPersonaje.getPersonaje().getTurnos() > 0){
            ControladorPersonaje.atacar((Ataque)carta, ControladorPersonaje.getPersonaje(), ControladorEnemigo.getEnemigo(), context);
            ControladorPersonaje.getPersonaje().setTurnos(ControladorPersonaje.getPersonaje().getTurnos() - carta.getCoste());
        }else{
            Toast.makeText(context, "No tienes energia suficiente", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class HolderMazo extends RecyclerView.ViewHolder {

        ImageView imgFotoCarta;
        TextView lblDescripcionCarta, lblNombreCarta;
        Button imgCosteCarta;
        MaterialCardView cvCarta;

        public HolderMazo(@NonNull View itemView) {
            super(itemView);
            imgFotoCarta = itemView.findViewById(R.id.imgFotoCarta);
            lblDescripcionCarta = itemView.findViewById(R.id.lblDescripcionCarta);
            lblNombreCarta = itemView.findViewById(R.id.lblNombreCarta);
            imgCosteCarta = itemView.findViewById(R.id.imgCosteCarta);
            cvCarta = itemView.findViewById(R.id.cvCarta);
        }
    }
}
