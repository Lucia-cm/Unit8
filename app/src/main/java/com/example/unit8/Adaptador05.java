package com.example.unit8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador05 extends RecyclerView.Adapter <Adaptador05.MiHolder> {
    private List<Encapsulador> entradas;

    public Adaptador05(List<Encapsulador> entradas) {
        this.entradas = entradas;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view= LayoutInflater.from(parent.getContext()).inflate(R_layout_IdView,parent,false);
        //no funciona, el siguiente le sustituye:
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.carta, parent, false);
        return new MiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        holder.imagen.setImageResource(entradas.get(position).getIdImagen());
        holder.titulo.setText(entradas.get(position).getTextoTitulo());
        holder.texto.setText(String.valueOf(entradas.get(position).getTextoContenido()));
    }

    @Override
    public int getItemCount() {
        return entradas.size();
    }


    public static class MiHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView titulo;
        public TextView texto;
        public MiHolder(View view){
            super(view);
            imagen=(ImageView) view.findViewById(R.id.imagen);
            titulo=(TextView) view.findViewById(R.id.titulo);
            texto=(TextView) view.findViewById(R.id.texto);
        }
    }
}
