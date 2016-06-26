package com.erikthegod.gym.modelo;

import java.util.ArrayList;

/**
 *
 * @author ErikTheGod
 */
public class Ejercicios {

    private String nombre;
    private ArrayList<Series> seriesEjercicios = new ArrayList();

    public Ejercicios(String nombreEjercicio) {
        nombre = nombreEjercicio;
    }

    public Ejercicios(String nombre, ArrayList serie) {
        this.nombre = nombre;
        this.seriesEjercicios = serie;
    }

    public Ejercicios() {

    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Series> getSeries() {
        return seriesEjercicios;
    }

}
