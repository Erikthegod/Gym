package com.erikthegod.gym;

import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kinton
 */
public class Ejercicios {

    private String nombre;
    private ArrayList<Series> seriesEjercicios = new ArrayList();
    GestorBBDD gest = new GestorBBDD();
    public static Ejercicios ej;
    public static ArrayList<Ejercicios> ejercicios = new ArrayList();
    public static Ejercicios ejercicioRutina;
    public static ArrayList<Ejercicios> ejerciciosRutina = new ArrayList();

    Ejercicios(String nombreEjercicio) {
        nombre = nombreEjercicio;
    }

    public Ejercicios(String nombre, ArrayList serie) {
        this.nombre = nombre;
        this.seriesEjercicios = serie;
    }

    Ejercicios() {

    }

    public void recogerEjercicios() throws ClassNotFoundException, SQLException {
        gest.conectar();
        gest.sql = "SELECT * from EjerciciosNom";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            ej = new Ejercicios(gest.rs.getString("Nombre"));
            ejercicios.add(ej);
        }
        gest.c.close();
    }

    public void recogerNombreEjerciciosRutina() throws ClassNotFoundException, SQLException {
        gest.conectar();
        gest.sql = "SELECT * from Rutinas ";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            ejercicioRutina = new Ejercicios(gest.rs.getString("Ejercicio"));
            ejerciciosRutina.add(ejercicioRutina);
        }
        gest.c.close();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Series> getSeries() {
        return seriesEjercicios;
    }

}
