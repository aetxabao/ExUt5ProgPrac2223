package com.masanz.prog.ut5.exam;

public class Persona {
    private String nombre;
    private int puntos;

    public Persona(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return nombre + " (" + puntos + ")";
    }

}
