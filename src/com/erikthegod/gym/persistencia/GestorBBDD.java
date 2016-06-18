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
 * @author kinton
 */
public class GestorBBDD {

    public Connection c = null;//Conexión
    public Statement stmt = null;//Sentencia
    public String sql = null;//Cadena con la sentencia sql
    public ResultSet rs = null;//Conjunto de resultados
    public static final String URL_CASA = "jdbc:sqlite:C:/Users/kinton/Documents/NetBeansProjects/Gym/GYM.db";

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

    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");//Carga del driver
        c = DriverManager.getConnection(URL_CASA);
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

    public void crearRutina(ArrayList<Ejercicios> ejerciciosRutina, String nombreRutina) throws SQLException, ClassNotFoundException {
        conectar();
        try {
            for (int i = 0; i < ejerciciosRutina.size(); i++) {
                for (int x = 0; x < ejerciciosRutina.get(i).getSeries().size(); x++) {
                    sql = "insert into Rutinas values ('" + nombreRutina + "','" + ejerciciosRutina.get(i).getNombre() + "'," + x + "," + ejerciciosRutina.get(i).getSeries().get(x).getRepeticiones() + "," + ejerciciosRutina.get(i).getSeries().get(x).getRmSerie() + ");";
                    stmt.executeUpdate(sql);
                }
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
        c.close();
    }

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
}
