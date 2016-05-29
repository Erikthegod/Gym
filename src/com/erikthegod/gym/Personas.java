/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym;

import com.erikthegod.gym.persistencia.GestorBBDD;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kinton
 */
public class Personas {
    private String nombre;
    GestorBBDD gest = new GestorBBDD();
    public static Personas per;
    public static ArrayList<Personas> personas = new ArrayList();

    public Personas(String nombrePersona) {
        nombre = nombrePersona;
    }

    public Personas() {
        
    }

    public void recogerPersonas() throws ClassNotFoundException, SQLException {
        gest.conectar();
        gest.sql = "SELECT * from Personas";
        gest.rs = gest.stmt.executeQuery(gest.sql);
        while (gest.rs.next()) {
            per = new Personas(gest.rs.getString("Nombre"));
            personas.add(per);
        }
        gest.c.close();
    }

    public String getNombre() {
        return nombre;
    }
}
