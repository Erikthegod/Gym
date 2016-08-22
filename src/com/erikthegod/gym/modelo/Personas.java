package com.erikthegod.gym.modelo;

/**
 *
 * @author kinton
 */
public class Personas {

    private String nombre;
    private String pass;

    public Personas(String nombrePersona) {
        nombre = nombrePersona;
    }

    public Personas(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public Personas() {

    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }
    
}
