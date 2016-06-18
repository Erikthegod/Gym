package com.erikthegod.gym.modelo;

import com.erikthegod.gym.persistencia.GestorBBDD;
import java.util.ArrayList;

/**
 *
 * @author kinton
 */
public class Ejercicios {

    private String nombre;
    private ArrayList<Series> seriesEjercicios = new ArrayList();
    GestorBBDD gest = new GestorBBDD();

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
