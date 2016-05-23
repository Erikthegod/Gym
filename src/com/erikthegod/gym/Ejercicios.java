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
    GestorBBDD gest = new GestorBBDD();
    public static Ejercicios ej;
    public static ArrayList<Ejercicios> ejercicios = new ArrayList();

    Ejercicios(String nombreEjercicio) {
        nombre = nombreEjercicio;
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

    public String getNombre() {
        return nombre;
    }
}
