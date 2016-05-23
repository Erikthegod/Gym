/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym;

import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;

/**
 *
 * @author kinton
 */
public class Calculator {

    GestorBBDD gest = new GestorBBDD();
    int PorcentajeRM;
    String numeroRepes;
    double velocidad;
    String metros;

    public void recogerEjercicios(String ejercicio, String segundos, String peso, double RM, String persona) throws ClassNotFoundException, SQLException {
        gest.conectar();

        gest.sql = "SELECT * from Medidas where Persona = '" + persona + "' and Ejercicio =  '" + ejercicio + "'";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            metros = gest.rs.getString("Metros");         
        }
        
        velocidad = Double.valueOf(metros) / Double.valueOf(segundos);
        
        comprobarEjercicio(ejercicio); 
        
        gest.sql = "SELECT * from Ejercicios where Velocidad =" + velocidad + " and Nombre = '" + ejercicio + "';";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            PorcentajeRM = gest.rs.getInt("PorcentajeRM");
            JOptionPane.showMessageDialog(null, PorcentajeRM);
        }
        double pesoPedido = (RM * Double.valueOf(peso)) / PorcentajeRM;
        gest.sql = "SELECT * from Ejercicios where PorcentajeRM =" + RM + " and Nombre='" + ejercicio + "';";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            numeroRepes = gest.rs.getString("RepeticionesMax");
        }
        JOptionPane.showMessageDialog(null, "Peso: " + Math.rint(pesoPedido * 100) / 100 + " Numero Repeticiones: " + numeroRepes);
        gest.c.close();
    }
    
    public void comprobarEjercicio(String ejercicio){
        if (ejercicio.compareTo("PressBanca") == 0) {
            if (velocidad > 0.90) {
                velocidad = 0.94;
            } else if (velocidad > 0.82 && velocidad <= 0.90) {
                velocidad = 0.86;
            } else if (velocidad > 0.73 && velocidad <= 0.82) {
                velocidad = 0.77;
            } else if (velocidad > 0.65 && velocidad <= 0.73) {
                velocidad = 0.69;
            } else if (velocidad > 0.57 && velocidad <= 0.65) {
                velocidad = 0.61;
            } else if (velocidad > 0.49 && velocidad <= 0.57) {
                velocidad = 0.53;
            } else if (velocidad > 0.41 && velocidad <= 0.49) {
                velocidad = 0.45;
            } else if (velocidad > 0.34 && velocidad <= 0.41) {
                velocidad = 0.37;
            } else if (velocidad > 0.27 && velocidad <= 0.34) {
                velocidad = 0.30;
            } else if (velocidad > 0.19 && velocidad <= 0.27) {
                velocidad = 0.22;
            } else if (velocidad <= 0.19) {
                velocidad = 0.15;
            }
        }
        if (ejercicio.compareTo("Sentadilla")==0){
            if (velocidad > 1.09) {
                velocidad = 1.13;
            } else if (velocidad > 1.02 && velocidad <= 1.09) {
                velocidad = 1.06;
            } else if (velocidad > 0.73 && velocidad <= 1.02) {
                velocidad = 0.77;
            } else if (velocidad > 0.65 && velocidad <= 0.73) {
                velocidad = 0.69;
            } else if (velocidad > 0.57 && velocidad <= 0.65) {
                velocidad = 0.61;
            } else if (velocidad > 0.49 && velocidad <= 0.57) {
                velocidad = 0.53;
            } else if (velocidad > 0.41 && velocidad <= 0.49) {
                velocidad = 0.45;
            } else if (velocidad > 0.34 && velocidad <= 0.41) {
                velocidad = 0.37;
            } else if (velocidad > 0.27 && velocidad <= 0.34) {
                velocidad = 0.30;
            } else if (velocidad > 0.19 && velocidad <= 0.27) {
                velocidad = 0.22;
            } else if (velocidad <= 0.19) {
                velocidad = 0.15;
            }
        }
    }
}
