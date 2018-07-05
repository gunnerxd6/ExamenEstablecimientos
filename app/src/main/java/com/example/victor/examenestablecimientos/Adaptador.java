package com.example.victor.examenestablecimientos;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.EstablecimientosViewHolder> {
    ArrayList<Establecimiento> establecimientos;
    Context ctx;

    public Adaptador(ArrayList<Establecimiento> establecimientos, Context ctx) {
        this.establecimientos = establecimientos;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public EstablecimientosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent, false);
        EstablecimientosViewHolder holder = new EstablecimientosViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EstablecimientosViewHolder holder, int position) {
        final Establecimiento establecimiento = establecimientos.get(position);
        holder.nombre.setText(establecimiento.getNombre());
        holder.tipo.setText(establecimiento.getTipo());
        holder.items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ctx, InformacionActivity.class);
                i.putExtra("nombre", establecimiento.getNombre());
                i.putExtra("direccion", establecimiento.getDireccion());
                i.putExtra("telefono", establecimiento.getTelefono());
                i.putExtra("correo", establecimiento.getCorreo());
                i.putExtra("web", establecimiento.getWeb());
                i.putExtra("tipo", establecimiento.getTipo());
                i.putExtra("ensenanza", establecimiento.getEnsenanza());
                i.putExtra("nivel", establecimiento.getNivel());
                i.putExtra("director", establecimiento.getDirector());
                i.putExtra("altitud", establecimiento.getAltitud());
                i.putExtra("latitud", establecimiento.getLatitud());
                ctx.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return establecimientos.size();
    }


    public static class EstablecimientosViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, tipo;
        ConstraintLayout items;

        public EstablecimientosViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tv_nombre);
            tipo = itemView.findViewById(R.id.tv_tipo);
            items = itemView.findViewById(R.id.items_lista);


        }
    }

}

