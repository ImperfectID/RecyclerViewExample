package com.naldana.admintarea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.naldana.admintarea.adapter.RecyclerViewAdpaterTareas;
import com.naldana.admintarea.modelo.Tarea;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdpaterTareas adpaterTareas;
    private ArrayList<Tarea> tareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos la referencia
        recyclerView = findViewById(R.id.recycler_view_tareas);

        //Setear El layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tareas = new ArrayList<>();

        tareas.add(new Tarea("asd", "asd", true));
        tareas.add(new Tarea("asd1", "asd1", true));
        tareas.add(new Tarea("asd2", "asd2", true));
        tareas.add(new Tarea("asd3", "asd3", true));
        tareas.add(new Tarea("asd4", "asd4", false));
        tareas.add(new Tarea("asd5", "asd5", false));
        tareas.add(new Tarea("asd6", "asd6", false));
        tareas.add(new Tarea("asd7", "asd7", false));

        adpaterTareas = new RecyclerViewAdpaterTareas(tareas) {
            @Override
            public void OnVerClick(View v, int pos) {
                Toast.makeText(getApplicationContext(), "Se dio ver a " + pos, Toast.LENGTH_SHORT)
                        .show();
                tareas.remove(pos);
                notifyItemRemoved(pos);
                notifyItemRangeChanged(pos, tareas.size());
            }
        };


        // Setear el adpatador
        recyclerView.setAdapter(adpaterTareas);

    }

    public void agregar(View v) {
        recyclerView.scrollToPosition(1);

        int index = tareas.size();
        tareas.add(0, new Tarea("Titulo " + index, "Subtitulo" + index, index % 2 == 0 ? true : false));
        adpaterTareas.notifyItemInserted(0);
        adpaterTareas.notifyItemRangeChanged(0,tareas.size());
    }
}
