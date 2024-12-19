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
import com.jah.aplicacion_inventada.Modelo.FamiliaCarta.Carta;
import com.jah.aplicacion_inventada.R;

import java.util.List;

public class AdaptadorCartas extends RecyclerView.Adapter<AdaptadorCartas.HolderCartas>{

    List<Carta> dataset;
    Context context;
    Carta c;

    public AdaptadorCartas(List<Carta> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public AdaptadorCartas.HolderCartas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.cartas, parent, false);
        return new HolderCartas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCartas.HolderCartas holder, int position) {
        c = dataset.get(position);

        holder.imgCoste.setText(String.valueOf(c.getCoste()));
        holder.lblNombre.setText(c.getNombre());
        holder.imgFoto.setImageResource(c.getImagen());
        holder.lblDescripcion.setText(c.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class HolderCartas extends RecyclerView.ViewHolder {

        Button imgCoste;
        ImageView imgFoto;
        TextView lblNombre, lblDescripcion;

        public HolderCartas(@NonNull View itemView) {
            super(itemView);
            imgCoste = itemView.findViewById(R.id.imgCoste);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblDescripcion = itemView.findViewById(R.id.lblDescripcion);
        }
    }
}
