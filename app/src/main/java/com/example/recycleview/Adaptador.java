
package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Vista> {

    public Context context;
    public List<String> nombre;
    public List<String> telefonos;
    int[] imagenes;

    public Adaptador(Context context, List<String> nombre,
                     List<String> telefonos, int[] imagenes) {

        this.context = context;
        this.nombre = nombre;
        this.telefonos = telefonos;
        this.imagenes = imagenes;
    }

    @NonNull
    @Override
    public Adaptador.Vista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.elemento, parent, false);

        return new Vista(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.Vista holder, int position) {

        holder.lblNombre.setText(nombre.get(position));
        holder.lblTelefono.setText(telefonos.get(position));
        holder.imgFoto.setImageResource(imagenes[position]);
    }

    @Override
    public int getItemCount() {
        return nombre.size();
    }

    public class Vista extends RecyclerView.ViewHolder {

        TextView lblNombre, lblTelefono;
        ImageView imgFoto;

        public Vista(@NonNull View itemView) {
            super(itemView);

            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblTelefono = itemView.findViewById(R.id.lblTelefono);
            imgFoto = itemView.findViewById(R.id.imgFoto);
        }
    }
}
