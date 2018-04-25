package com.naldana.admintarea.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.naldana.admintarea.R;
import com.naldana.admintarea.modelo.Tarea;

import java.util.ArrayList;

public abstract class RecyclerViewAdpaterTareas extends RecyclerView.Adapter<RecyclerViewAdpaterTareas.ViewHolder> {

    private ArrayList<Tarea> tareas;

    public RecyclerViewAdpaterTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tarea, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Tarea tarea = tareas.get(position);

        holder.titulo.setText(tarea.getTitulo());
        holder.detalle.setText(tarea.getDetalle());
        holder.complete.setChecked(tarea.isCompletada());

        holder.complete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                tarea.setCompletada(b);
                if (b) {
                    tareas.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position,tareas.size());
                }
            }
        });

        holder.ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnVerClick(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }

    public abstract void OnVerClick(View v, int pos);

    class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox complete;
        TextView titulo;
        TextView detalle;
        Button ver;

        public ViewHolder(View itemView) {
            super(itemView);
            detalle = itemView.findViewById(R.id.text_view_subtitulo_tarea);
            titulo = itemView.findViewById(R.id.text_view_titulo_tarea);
            complete = itemView.findViewById(R.id.checkbox_complete_tarea);
            ver = itemView.findViewById(R.id.button_ver);
        }
    }
}
