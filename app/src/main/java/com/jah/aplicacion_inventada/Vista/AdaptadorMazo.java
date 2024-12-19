package com.jah.aplicacion_inventada.Vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Carta;
import com.jah.aplicacion_inventada.R;

import java.util.List;

public class AdaptadorMazo extends RecyclerView.Adapter<AdaptadorMazo.HolderMazo> {

    List<Carta> dataSet;
    Context context;
    Carta c;

    public AdaptadorMazo(List<Carta> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public AdaptadorMazo.HolderMazo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
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
        holder.cvCarta.setOnClickListener(view -> jugarCarta());
    }

    private void jugarCarta() {
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
