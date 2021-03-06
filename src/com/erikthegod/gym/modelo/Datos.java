package com.erikthegod.gym.modelo;

/**
 *
 * @author ErikTheGod
 */
public class Datos {

    private String nombreEjercicio;
    private String nombrePersona;
    private String peso;
    private double velocidad;
    private String fecha;

    public Datos() {

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
