/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kinton
 */
public class Rutina {

    GestorBBDD gest = new GestorBBDD();
    public ArrayList<Ejercicios> ejerciciosRutina = new ArrayList();
    public ArrayList<Ejercicios> ejerciciosRecogidos;
    public ArrayList<Series> series = new ArrayList();
    Series serie;
    Ejercicios ejer;
    String nombreRutina;

    public void crearRutina(String nombreRutina) throws SQLException, ClassNotFoundException {
        gest.conectar();
        try {
            for (int i = 0; i < ejerciciosRutina.size(); i++) {
                for (int x = 0; x < ejerciciosRutina.get(i).getSeries().size(); x++) {
                    gest.sql = "insert into Rutinas values ('" + nombreRutina + "','" + ejerciciosRutina.get(i).getNombre() + "'," + x + "," + ejerciciosRutina.get(i).getSeries().get(x).repeticiones + "," + ejerciciosRutina.get(i).getSeries().get(x).rmSerie + ");";
                    gest.stmt.executeUpdate(gest.sql);
                }
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
        gest.c.close();
    }

    public Ejercicios recogerEjercicioRutina(String nombreRutina, String ejercicio) throws ClassNotFoundException, SQLException {
        gest.conectar();
        ejerciciosRecogidos = new ArrayList();
        gest.sql = "SELECT * from Rutinas where Nombre = '" + nombreRutina + "' and Ejercicio =  '" + ejercicio + "'";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            serie = new Series(gest.rs.getInt("Repeticiones"), gest.rs.getInt("RM"));
            series.add(serie);
        }
        ejer = new Ejercicios(ejercicio, series);
        return ejer;
    }
}
