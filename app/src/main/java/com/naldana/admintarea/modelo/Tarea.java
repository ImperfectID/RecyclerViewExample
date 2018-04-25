package com.naldana.admintarea.modelo;

public class Tarea {
    private String titulo;
    private String detalle;
    private boolean completada;


    public Tarea() {
    }

    public Tarea(String titulo, String detalle, boolean completada) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.completada = completada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
