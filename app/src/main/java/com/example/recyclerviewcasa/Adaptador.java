package com.example.recyclerviewcasa;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    ArrayList<?>listado;
    Context contexto;
    int r_layout_id;

    private View.OnClickListener onClickListener;

    public Adaptador(ArrayList<?> listado, Context contexto, int r_layout_id) {
        this.listado = listado;
        this.contexto = contexto;
        this.r_layout_id = r_layout_id;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento= LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento,parent,false);
        elemento.setOnClickListener(onClickListener);
        return new ViewHolder(elemento);

    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        Encapsulador encapsulador = (Encapsulador) listado.get(position);
        holder.representacionElementos(encapsulador);

    }

    @Override
    public int getItemCount() {
        return listado.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo, subtitulo;
        private ImageView imagen;
        private CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.tituloGrande);
            subtitulo = (TextView) itemView.findViewById(R.id.Subtitulo);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            imagen = (ImageView) itemView.findViewById(R.id.imagenElemento);
        }

        public void representacionElementos(Encapsulador e){
            titulo.setText(e.getTitulo());
            subtitulo.setText(e.getSubtitulo());
            checkBox.setChecked(e.isCheckbox());
            imagen.setImageResource(e.getImagen());
        }
    }
}
