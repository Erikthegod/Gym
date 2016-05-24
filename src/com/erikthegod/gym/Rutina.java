/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym;

import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kinton
 */
public class Rutina {

    GestorBBDD gest = new GestorBBDD();
    public ArrayList<Ejercicios> ejerciciosRutina = new ArrayList();
    String nombreRutina;

    public void crearRutina(String nombreRutina) throws SQLException, ClassNotFoundException {
        gest.conectar();
        try {
            for (int i = 0; i < ejerciciosRutina.size(); i++) {
                for (int x = 0; x < ejerciciosRutina.get(i).getSeries().size(); x++) {
                    gest.sql = "insert into Rutinas values ('" + nombreRutina + "','" + ejerciciosRutina.get(i).getNombre() + "'," + x + "," + ejerciciosRutina.get(i).getSeries().get(x).repeticiones + ");";
                    System.out.println(gest.sql);
                    gest.stmt.executeUpdate(gest.sql);
                }
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
        gest.c.close();
    }
}
