package com.erikthegod.gym.modelo;

import com.erikthegod.gym.persistencia.GestorBBDD;

/**
 *
 * @author kinton
 */
public class Personas {

    private String nombre;
    GestorBBDD gest = new GestorBBDD();

    public Personas(String nombrePersona) {
        nombre = nombrePersona;
    }

    public Personas() {

    }

    public String getNombre() {
        return nombre;
    }
}
