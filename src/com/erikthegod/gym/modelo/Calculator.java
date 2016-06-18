/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym.modelo;

import com.erikthegod.gym.persistencia.GestorBBDD;
import java.sql.SQLException;

/**
 *
 * @author kinton
 */
public class Calculator {

    GestorBBDD gest = new GestorBBDD();
    private double pesoPedido;
    private double velocidad;
    private double metros;
    private int RM;

    public double calculoTotal(String ejercicio, String segundos, String peso, int rm, String persona) throws ClassNotFoundException, SQLException {
        metros = gest.recogerMetros(ejercicio, persona);
        velocidad = compararEjercicio(ejercicio, gest.calcularVelocidad(metros, segundos));
        RM = gest.recogerRM(ejercicio, velocidad);
        return calcularPeso(rm, RM, peso);
    }

    /**
     * Calcula el peso del rm deseado con un rm dado y el peso de ese rm dado
     *
     * @param rm Rm deseado
     * @param porcenRM Rm del peso dado
     * @param peso Peso dado
     * @return Peso deseado
     */
    public double calcularPeso(int rm, int porcenRM, String peso) {
        pesoPedido = (rm * Double.valueOf(peso)) / porcenRM;
        return pesoPedido;
    }

    public double compararEjercicio(String ejercicio, double velocidadReal) {
        if (ejercicio.compareTo("PressBanca") == 0) {
            if (velocidadReal > 0.90) {
                velocidadReal = 0.94;
            } else if (velocidadReal > 0.82 && velocidadReal <= 0.90) {
                velocidadReal = 0.86;
            } else if (velocidadReal > 0.73 && velocidadReal <= 0.82) {
                velocidadReal = 0.77;
            } else if (velocidadReal > 0.65 && velocidadReal <= 0.73) {
                velocidadReal = 0.69;
            } else if (velocidadReal > 0.57 && velocidadReal <= 0.65) {
                velocidadReal = 0.61;
            } else if (velocidadReal > 0.49 && velocidadReal <= 0.57) {
                velocidadReal = 0.53;
            } else if (velocidadReal > 0.41 && velocidadReal <= 0.49) {
                velocidadReal = 0.45;
            } else if (velocidadReal > 0.34 && velocidadReal <= 0.41) {
                velocidadReal = 0.37;
            } else if (velocidadReal > 0.27 && velocidadReal <= 0.34) {
                velocidadReal = 0.30;
            } else if (velocidadReal > 0.19 && velocidadReal <= 0.27) {
                velocidadReal = 0.22;
            } else if (velocidadReal <= 0.19) {
                velocidadReal = 0.15;
            }
        }
        if (ejercicio.compareTo("Remo") == 0) {
            if (velocidadReal > 1.25) {
                velocidadReal = 1.49;
            } else if (velocidadReal > 1.09 && velocidadReal <= 1.25) {
                velocidadReal = 1.13;
            } else if (velocidadReal > 1.02 && velocidadReal <= 1.09) {
                velocidadReal = 1.06;
            } else if (velocidadReal > 0.94 && velocidadReal <= 1.02) {
                velocidadReal = 0.99;
            } else if (velocidadReal > 0.89 && velocidadReal <= 0.94) {
                velocidadReal = 0.92;
            } else if (velocidadReal > 0.82 && velocidadReal <= 0.89) {
                velocidadReal = 0.85;
            } else if (velocidadReal > 0.75 && velocidadReal <= 0.82) {
                velocidadReal = 0.78;
            } else if (velocidadReal > 0.68 && velocidadReal <= 0.75) {
                velocidadReal = 0.72;
            } else if (velocidadReal > 0.61 && velocidadReal <= 0.68) {
                velocidadReal = 0.65;
            } else if (velocidadReal > 0.55 && velocidadReal <= 0.61) {
                velocidadReal = 0.58;
            } else if (velocidadReal <= 0.55) {
                velocidadReal = 0.52;
            }
        }
        return velocidadReal;
    }

}
