/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kinton
     */
public class GestorBBDD {

    public Connection c = null;//Conexión
    public Statement stmt = null;//Sentencia
    public String sql = null;//Cadena con la sentencia sql
    public ResultSet rs = null;//Conjunto de resultados

    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");//Carga del driver
        c = DriverManager.getConnection("jdbc:sqlite:E:/Proyectos/GYM/Gym/GYM.db");
        stmt = c.createStatement();
    }

}
