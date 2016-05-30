/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym.persistencia;

import com.erikthegod.gym.Calculator;
import com.erikthegod.gym.Datos;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author kinton
 */
public class GestorBBDD {

    public Connection c = null;//Conexión
    public Statement stmt = null;//Sentencia
    public String sql = null;//Cadena con la sentencia sql
    public ResultSet rs = null;//Conjunto de resultados
    public static final String URL_CASA = "jdbc:sqlite:C:/Users/kinton/Documents/NetBeansProjects/Gym/GYM.db";
    public static final String URL_CLASE = "jdbc:sqlite:E:/Proyectos/GYM/Gym/GYM.db";
    
    Calendar c2 = new GregorianCalendar();

    private String fecha;
    private double metros;
    private int porcentajeRM;
    private String numeroRepes;
    private double velocidad;

    Datos dato;
    ArrayList<Datos> datos = new ArrayList();
    Datos pesoD;
    ArrayList<Datos> pesos = new ArrayList();

    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");//Carga del driver
        c = DriverManager.getConnection(URL_CLASE);
        stmt = c.createStatement();
    }

    public double calcularVelocidad(double metros, String segundos) {
        velocidad = metros / Double.valueOf(segundos);
        return Math.rint(velocidad * 100) / 100;
    }

    public void insertarDato(String ejercicio, String persona, String peso, String segundos) throws ClassNotFoundException, SQLException {
        conectar();
        fecha = Integer.toString(c2.get(Calendar.DAY_OF_MONTH)) + "-" + (Integer.toString(c2.get(Calendar.MONTH) + 1));
        sql = "insert into Datos values ('" + ejercicio + "','" + persona + "'," + parseInt(peso) + "," + calcularVelocidad(recogerMetros(ejercicio, persona), segundos) + ",'" + fecha + "');";
        stmt.executeUpdate(sql);
    }

    public Double recogerMetros(String ejercicio, String persona) throws SQLException, ClassNotFoundException {
        conectar();
        sql = "SELECT * from Medidas where Persona = '" + persona + "' and Ejercicio =  '" + ejercicio + "'";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            metros = Double.valueOf(rs.getString("Metros"));
        }
        return metros;
    }

    public int recogerRM(String ejercicio, double velocidad) throws SQLException, ClassNotFoundException {
        conectar();
        sql = "SELECT * from Ejercicios where Velocidad =" + velocidad + " and Nombre = '" + ejercicio + "';";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            porcentajeRM = rs.getInt("PorcentajeRM");
        }
        return porcentajeRM;
    }

    public String calcularRepMax(int rm, String ejercicio) throws SQLException, ClassNotFoundException {
        conectar();
        sql = "SELECT * from Ejercicios where PorcentajeRM =" + rm + " and Nombre='" + ejercicio + "';";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            numeroRepes = rs.getString("RepeticionesMax");
        }
        return numeroRepes;
    }

    public ArrayList<Datos> recogerDatos(String nombrePersona, String nombreEjercicio, String peso) throws ClassNotFoundException, SQLException {
        conectar();
        sql = "SELECT Velocidad , Fecha from Datos where Persona = '" + nombrePersona + "' and Ejercicio = '" + nombreEjercicio + "' and Peso =" + peso;
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            dato = new Datos(nombreEjercicio, nombrePersona, peso, rs.getDouble("Velocidad"), rs.getString("Fecha"));
            datos.add(dato);
        }
        return datos;
    }

    public ArrayList<Datos> recogerPesos(String nombrePersona, String nombreEjercicio) throws ClassNotFoundException, SQLException {
        conectar();
        sql = "SELECT distinct Peso from Datos where Persona = '" + nombrePersona + "' and Ejercicio = '" + nombreEjercicio + "'";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            pesoD = new Datos(rs.getString("Peso"));
            pesos.add(pesoD);
        }
        return pesos;
    }

}
