package com.erikthegod.gym.persistencia;

import com.erikthegod.gym.modelo.Datos;
import com.erikthegod.gym.modelo.Ejercicios;
import com.erikthegod.gym.modelo.Personas;
import com.erikthegod.gym.modelo.Rutina;
import com.erikthegod.gym.modelo.Series;
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
 * @author ErikTheGod
 */
public class GestorBBDD {

    public Connection c = null;//Conexión
    public Statement stmt = null;//Sentencia
    public String sql = null;//Cadena con la sentencia sql
    public ResultSet rs = null;//Conjunto de resultados
    public static final String URL_CASA = "jdbc:sqlite:GYM.db";

    Calendar c2 = new GregorianCalendar();

    private String fecha;
    private double metros;
    private int porcentajeRM;
    private String numeroRepes;
    private double velocidad;

    private Datos dato;
    private ArrayList<Datos> datos = new ArrayList();
    private Datos pesoD;
    private ArrayList<Datos> pesos = new ArrayList();
    private Ejercicios ejer;
    private ArrayList<Ejercicios> ejercicios;
    private Series serie;
    private ArrayList<Series> series = new ArrayList();
    private ArrayList<Rutina> nombresRutinas = new ArrayList();
    private Rutina nombreRut;
    private Personas per;
    private ArrayList<Personas> personas = new ArrayList();
    public static Personas usuario;

    /**
     * Conecta a la BBDD
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");//Carga del driver
        c = DriverManager.getConnection(URL_CASA);
        stmt = c.createStatement();
    }

    /**
     * Metodo que calcula la velocidad del ejercicio pasandole la distancia
     * recorrida en el ejercicio y el tiempo que se tarda en realizarlo
     *
     * @param metros Distancia del ejercicio de cada persona
     * @param segundos Tiempo en realizar el movimiento
     * @return Velocidad en m/s
     */
    public double calcularVelocidad(double metros, String segundos) {
        velocidad = metros / Double.valueOf(segundos);
        return Math.rint(velocidad * 100) / 100;
    }

    /**
     * Metodo que inserta los datos de los ejercicios introducidos por la
     * persona, se guarda el ejercicio , la persona , el peso tirado , la
     * velocidad y la fecha
     *
     * @param ejercicio Ejercicio que se realiza
     * @param persona Persona que realiza el ejercicio
     * @param peso Peso levantado durante el ejercicio
     * @param segundos Segundos de una repeticion
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void insertarDato(String ejercicio, String persona, String peso, String segundos) throws ClassNotFoundException, SQLException {
        conectar();
        fecha = Integer.toString(c2.get(Calendar.DAY_OF_MONTH)) + "-" + (Integer.toString(c2.get(Calendar.MONTH) + 1));
        sql = "insert into Datos values ('" + ejercicio + "','" + persona + "'," + parseInt(peso) + "," + calcularVelocidad(recogerMetros(ejercicio, persona), segundos) + ",'" + fecha + "');";
        stmt.executeUpdate(sql);
    }

    /**
     * Metodo que recoger de la BBDD la medida de una persona en un ejercicio
     *
     * @param ejercicio Ejercicio que realiza la persona
     * @param persona Persona que lo realiza
     * @return Distancia en metros que se recoge de la BBDD
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Double recogerMetros(String ejercicio, String persona) throws SQLException, ClassNotFoundException {
        conectar();
        sql = "SELECT * from Medidas where Persona = '" + persona + "' and Ejercicio =  '" + ejercicio + "'";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            metros = Double.valueOf(rs.getString("Metros"));
        }
        return metros;
    }

    /**
     * Metodo que recoge el RM al que corresponde una velocidad de un ejercicio
     *
     * @param ejercicio Ejercicio
     * @param velocidad Velocidad a la que se realiza el ejercicio
     * @return RM correspondiente a esa velocidad para ese ejercicio
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int recogerRM(String ejercicio, double velocidad) throws SQLException, ClassNotFoundException {
        conectar();
        sql = "SELECT * from Ejercicios where Velocidad =" + velocidad + " and Nombre = '" + ejercicio + "';";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            porcentajeRM = rs.getInt("PorcentajeRM");
        }
        return porcentajeRM;
    }

    /**
     * Metodo que devuelve las repeticiones correspondientes a un rm y a un
     * ejercicio
     *
     * @param rm RM que se da
     * @param ejercicio Ejercicio
     * @return Numero repeticiones
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public String calcularRepMax(int rm, String ejercicio) throws SQLException, ClassNotFoundException {
        conectar();
        sql = "SELECT * from Ejercicios where PorcentajeRM =" + rm + " and Nombre='" + ejercicio + "';";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            numeroRepes = rs.getString("RepeticionesMax");
        }
        return numeroRepes;
    }

    /**
     * Metodo que recoge la velocidad y la fecha de la persona del ejercicio y
     * del peso dado
     *
     * @param nombrePersona Nombre persona
     * @param nombreEjercicio Nombre ejercicio
     * @param peso Peso
     * @return Array de datos con los recogidos dentro
     * @throws ClassNotFoundException
     * @throws SQLException
     */
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

    /**
     * Metodo que recoge los pesos que tiene cada persona por cada ejercicio
     * registrados para mostrarlos a la hora de pedir una grafica
     *
     * @param nombrePersona Persona
     * @param nombreEjercicio Ejercicio
     * @return Array de datos que contiene los pesos de los que dispone cada
     * persona
     * @throws ClassNotFoundException
     * @throws SQLException
     */
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

    /**
     * Metodo que inserta una rutina creada por el usuario con sus distintas
     * series , repeticiones y rm por cada serie de cada ejercicio
     *
     * @param ejerciciosRutina Array con los ejercicios que tendra la rutina
     * @param nombreRutina Nombre de la rutina
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void crearRutina(ArrayList<Ejercicios> ejerciciosRutina, String nombreRutina) throws SQLException, ClassNotFoundException {
        conectar();
        for (int i = 0; i < ejerciciosRutina.size(); i++) {
            for (int x = 0; x < ejerciciosRutina.get(i).getSeries().size(); x++) {
                sql = "insert into Rutinas values ('" + nombreRutina + "','" + ejerciciosRutina.get(i).getNombre() + "'," + x + "," + ejerciciosRutina.get(i).getSeries().get(x).getRepeticiones() + "," + ejerciciosRutina.get(i).getSeries().get(x).getRmSerie() + ");";
                stmt.executeUpdate(sql);
            }
        }
        c.close();
    }

    /**
     * Metodo que recoge las series, repeticiones y el rm de una rutina y un
     * ejercicio de esa rutina
     *
     * @param nombreRutina Nombre rutina
     * @param ejercicio Nombre ejercicio
     * @return Objeto de ejercicio con sus series , repeticiones y rm
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Ejercicios recogerEjercicioRutina(String nombreRutina, String ejercicio) throws ClassNotFoundException, SQLException {
        conectar();
        sql = "SELECT * from Rutinas where Nombre = '" + nombreRutina + "' and Ejercicio =  '" + ejercicio + "'";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            serie = new Series(rs.getInt("Repeticiones"), rs.getInt("RM"));
            series.add(serie);
        }
        ejer = new Ejercicios(ejercicio, series);
        return ejer;
    }

    /**
     * Metodo que recoge el nombre de las rutinas que hay
     *
     * @return Array de rutinas con su nombre
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Rutina> recogerNombreRutina() throws ClassNotFoundException, SQLException {
        conectar();
        sql = "select distinct Nombre from Rutinas";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            nombreRut = new Rutina(rs.getString("Nombre"));
            nombresRutinas.add(nombreRut);
        }
        return nombresRutinas;
    }

    /**
     * Metodo que recoge los ejercicios existentes en la BBDD
     *
     * @return Array de Ejercicios con su nombre
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Ejercicios> recogerEjercicios() throws ClassNotFoundException, SQLException {
        conectar();
        ejercicios = new ArrayList();
        sql = "SELECT * from EjerciciosNom";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ejer = new Ejercicios(rs.getString("Nombre"));
            ejercicios.add(ejer);
        }
        c.close();
        return ejercicios;
    }

    /**
     * Metodo que recoge los ejercicios de una rutina en especifico
     *
     * @param nombreRutina Vombre de la rutina
     * @return ArrayList de ejercicios con el nombre
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Ejercicios> recogerNombreEjerciciosRutina(String nombreRutina) throws ClassNotFoundException, SQLException {
        conectar();
        ejercicios = new ArrayList();
        sql = "SELECT distinct Ejercicio from Rutinas where Nombre = '" + nombreRutina + "'";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ejer = new Ejercicios(rs.getString("Ejercicio"));
            ejercicios.add(ejer);
        }
        c.close();
        return ejercicios;
    }

    /**
     * Metodo que recoge los ejercicios que ha realizado cada persona para hacer
     * los graficos
     *
     * @param nombrePersona Nombre persona
     * @return ArrayList de ejercicios con el nombre
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Ejercicios> recogerEjerciciosPesona(String nombrePersona) throws ClassNotFoundException, SQLException {
        conectar();
        ejercicios = new ArrayList();
        sql = "SELECT distinct Ejercicio from Datos where Persona = '" + nombrePersona + "'";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ejer = new Ejercicios(rs.getString("Ejercicio"));
            ejercicios.add(ejer);
        }
        c.close();
        return ejercicios;
    }

    /**
     * Metodo que recoge las personas registradas en la BBDD
     *
     * @return ArrayList de personas
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Personas> recogerPersonas() throws ClassNotFoundException, SQLException {
        conectar();
        sql = "SELECT * from Personas";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            per = new Personas(rs.getString("Nombre"));
            personas.add(per);
        }
        c.close();
        return personas;
    }

    /**
     * Metodo que comprueba que el login es correcto
     * @param persona
     * @param pass
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public boolean comprobarRegistro(String persona,String pass) throws ClassNotFoundException, SQLException {
        conectar();
        boolean registrado = false;
        sql = "SELECT * from Personas";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            if(persona.compareTo(rs.getString("Nombre"))==0 && pass.compareTo(rs.getString("Pass"))==0){
                registrado = true;
                usuario = new Personas (persona,pass);
            }
        }
        c.close();
        return registrado;
    }
    
    /**
     * Metodo que comprueba si un usuario ya esta registrado
     * @param persona
     * @param pass
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public boolean comprobarUsuario(String persona,String pass) throws ClassNotFoundException, SQLException {
        conectar();
        boolean registrado = false;
        sql = "SELECT * from Personas";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            if(persona.compareTo(rs.getString("Nombre"))==0){
                registrado = true;
            }
        }
        c.close();
        return registrado;
    }

    /**
     * Metodo que registra nuevos usuarios
     * @param persona
     * @param pass
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void registrarPersonas(String persona, String pass) throws SQLException, ClassNotFoundException {
        conectar();
        sql = "insert into Personas values ('" + persona + "','" + pass + "');";
        stmt.executeUpdate(sql);
        c.close();
    }
}
