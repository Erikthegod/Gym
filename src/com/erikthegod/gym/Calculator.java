/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym;

import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

/**
 *
 * @author kinton
 */
public class Calculator {

    GestorBBDD gest = new GestorBBDD();
    ArrayList <Integer> cantSeries = new ArrayList();
    int porcentajeRM;
    String numeroRepes;
    double velocidad;
    String metros;
    Calendar c2 = new GregorianCalendar();
    String fecha;
    double pesoPedido;

    public double calculoTotal(String ejercicio, String segundos, String peso, int rm, String persona) throws ClassNotFoundException, SQLException {
        gest.conectar();
        recogerMetros(ejercicio, persona);
        calcularVelocidad(metros, segundos);       
        compararEjercicio(ejercicio);
        fecha = Integer.toString(c2.get(Calendar.DAY_OF_MONTH))+"-"+(Integer.toString(c2.get(Calendar.MONTH)+1));
        insertarDato(ejercicio, persona, peso, fecha);       
        recogerRM(ejercicio, velocidad);
        calcularPeso(rm, porcentajeRM, peso);
        calcularRepMax(rm, ejercicio);
        //JOptionPane.showMessageDialog(null, "Peso: " + Math.rint(pesoPedido * 100) / 100 + " Numero Repeticiones: " + numeroRepes);       
        gest.c.close();
        return pesoPedido;
    }
    
 
        
        
            

    public void compararEjercicio(String ejercicio) {
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
        if (ejercicio.compareTo("Remo") == 0) {
            if (velocidad > 1.25) {
                velocidad = 1.49;
            } else if (velocidad > 1.09 && velocidad <= 1.25) {
                velocidad = 1.13;
            } else if (velocidad > 1.02 && velocidad <= 1.09) {
                velocidad = 1.06;
            } else if (velocidad > 0.94 && velocidad <= 1.02) {
                velocidad = 0.99;
            } else if (velocidad > 0.89 && velocidad <= 0.94) {
                velocidad = 0.92;
            } else if (velocidad > 0.82 && velocidad <= 0.89) {
                velocidad = 0.85;
            } else if (velocidad > 0.75 && velocidad <= 0.82) {
                velocidad = 0.78;
            } else if (velocidad > 0.68 && velocidad <= 0.75) {
                velocidad = 0.72;
            } else if (velocidad > 0.61 && velocidad <= 0.68) {
                velocidad = 0.65;
            } else if (velocidad > 0.55 && velocidad <= 0.61) {
                velocidad = 0.58;
            } else if (velocidad <= 0.55) {
                velocidad = 0.52;
            }
        }
    }
    
    public void insertarDato(String ejercicio,String persona,String peso,String fecha){
        try {
            gest.sql = "insert into Datos values ('"+ejercicio+"','"+persona+"',"+parseInt(peso)+","+velocidad+",'"+fecha+"');";
            System.out.println(gest.sql);
            gest.stmt.executeUpdate(gest.sql);
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }
    
    public void recogerMetros(String ejercicio,String persona) throws SQLException{
        gest.sql = "SELECT * from Medidas where Persona = '" + persona + "' and Ejercicio =  '" + ejercicio + "'";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            metros = gest.rs.getString("Metros");
            System.out.println(metros);
        }
    }
    
    public double calcularVelocidad(String metros,String segundos){
        velocidad = Double.valueOf(metros) / Double.valueOf(segundos);
        return velocidad;
    }
    
    public void recogerRM(String ejercicio,double velocidad) throws SQLException{
        gest.sql = "SELECT * from Ejercicios where Velocidad =" + velocidad + " and Nombre = '" + ejercicio + "';";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            porcentajeRM = gest.rs.getInt("PorcentajeRM");
            JOptionPane.showMessageDialog(null, porcentajeRM);
        }
    }
    
    /**
     * Calcula el peso del rm deseado con un rm dado y el peso de ese rm dado
     * @param rm Rm deseado
     * @param porcenajeRM Rm del peso dado
     * @param peso Peso dado
     * @return Peso deseado
     */
    public double calcularPeso(int rm,int porcenajeRM,String peso){
        pesoPedido = (rm * Double.valueOf(peso)) / porcentajeRM;
        return pesoPedido;
    }
    
    public String calcularRepMax(int rm,String ejercicio) throws SQLException{
        gest.sql = "SELECT * from Ejercicios where PorcentajeRM =" + rm + " and Nombre='" + ejercicio + "';";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            numeroRepes = gest.rs.getString("RepeticionesMax");
        }
        return numeroRepes;
    }
    
}
