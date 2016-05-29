/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym;

import static com.erikthegod.gym.Ejercicios.ejercicioPersona;
import static com.erikthegod.gym.Ejercicios.ejerciciosPersona;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kinton
 */
public class Datos {
    private String nombreEjercicio;
    private String nombrePersona;
    private String peso;
    private double velocidad;
    private String fecha;
    GestorBBDD gest = new GestorBBDD();
    public static Datos pesoD;
    public static ArrayList<Datos> pesos = new ArrayList();
    public static Datos dato;
    public static ArrayList<Datos> datos = new ArrayList();

    Datos() {
        
    }
    
    public void recogerPesos(String nombrePersona , String nombreEjercicio) throws ClassNotFoundException, SQLException{
        gest.conectar();
        gest.sql = "SELECT distinct Peso from Datos where Persona = '"+ nombrePersona+"' and Ejercicio = '"+nombreEjercicio+"'";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            pesoD = new Datos (gest.rs.getString("Peso"));
            pesos.add(pesoD);
        }
        gest.c.close();
    }
    public void recogerDatos(String nombrePersona , String nombreEjercicio , String peso) throws ClassNotFoundException, SQLException{
        gest.conectar();
        gest.sql = "SELECT Velocidad , Fecha from Datos where Persona = '"+ nombrePersona+"' and Ejercicio = '"+nombreEjercicio+"' and Peso ="+peso;
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            dato = new Datos (nombreEjercicio,nombrePersona,peso,gest.rs.getDouble("Velocidad"),gest.rs.getString("Fecha"));
            datos.add(dato);
        }
        gest.c.close();
    }

    public Datos(String peso) {
        this.peso = peso;
    }

    public Datos(String nombreEjercicio, String nombrePersona, String peso, double velocidad, String fecha) {
        this.nombreEjercicio = nombreEjercicio;
        this.nombrePersona = nombrePersona;
        this.peso = peso;
        this.velocidad = velocidad;
        this.fecha = fecha;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public String getPeso() {
        return peso;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public String getFecha() {
        return fecha;
    }
    
    
}
