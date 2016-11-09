package com.erikthegod.gym.modelo;

import com.erikthegod.gym.persistencia.GestorBBDD;
import java.sql.SQLException;

/**
 *
 * @author ErikTheGod
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
    
    public double rmUsado (String ejercicio, String segundos, String peso,String persona) throws SQLException, ClassNotFoundException{
        metros = gest.recogerMetros(ejercicio, persona);
        velocidad = compararEjercicio(ejercicio, gest.calcularVelocidad(metros, segundos));
        RM = gest.recogerRM(ejercicio, velocidad);
        return RM;
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
        if (ejercicio.compareTo("MediaSentadilla")==0){
            if (velocidadReal > 1.32) {
                velocidadReal = 1.35;
            } else if (velocidadReal > 1.26 && velocidadReal <= 1.32) {
                velocidadReal = 1.29;
            } else if (velocidadReal > 1.20 && velocidadReal <= 1.26) {
                velocidadReal = 1.23;
            } else if (velocidadReal > 1.14 && velocidadReal <= 1.20) {
                velocidadReal = 1.17;
            } else if (velocidadReal > 1.08 && velocidadReal <= 1.14) {
                velocidadReal = 1.11;
            } else if (velocidadReal > 1.02 && velocidadReal <= 1.08) {
                velocidadReal = 1.05;
            } else if (velocidadReal > 0.96 && velocidadReal <= 1.02) {
                velocidadReal = 0.99;
            } else if (velocidadReal > 0.90 && velocidadReal <= 0.96) {
                velocidadReal = 0.93;
            } else if (velocidadReal > 0.84 && velocidadReal <= 0.90) {
                velocidadReal = 0.87;
            } else if (velocidadReal > 0.78 && velocidadReal <= 0.84) {
                velocidadReal = 0.81;
            } else if (velocidadReal > 0.72 && velocidadReal <= 0.78) {
                velocidadReal = 0.75;
            } else if (velocidadReal > 0.66 && velocidadReal <= 0.72) {
                velocidadReal = 0.69;
            } else if (velocidadReal > 0.60 && velocidadReal <= 0.66) {
                velocidadReal = 0.63;
            } else if (velocidadReal > 0.54 && velocidadReal <= 0.60) {
                velocidadReal = 0.57;
            } else if (velocidadReal > 0.48 && velocidadReal <= 0.54) {
                velocidadReal = 0.51;
            } else if (velocidadReal > 0.42 && velocidadReal <= 0.48) {
                velocidadReal = 0.45;
            } else if (velocidadReal > 0.36 && velocidadReal <= 0.42) {
                velocidadReal = 0.39;
            } else if (velocidadReal <= 0.36) {
                velocidadReal = 0.33;
            }
        }
        if (ejercicio.compareTo("Sentadilla")==0){
            if (velocidadReal > 1.41) {
                velocidadReal = 1.45;
            } else if (velocidadReal > 1.35 && velocidadReal <= 1.41) {
                velocidadReal = 1.38;
            } else if (velocidadReal > 1.29 && velocidadReal <= 1.35) {
                velocidadReal = 1.32;
            } else if (velocidadReal > 1.21 && velocidadReal <= 1.29) {
                velocidadReal = 1.25;
            } else if (velocidadReal > 1.15 && velocidadReal <= 1.21) {
                velocidadReal = 1.18;
            } else if (velocidadReal > 1.09 && velocidadReal <= 1.15) {
                velocidadReal = 1.12;
            } else if (velocidadReal > 1.02 && velocidadReal <= 1.09) {
                velocidadReal = 1.05;
            } else if (velocidadReal > 0.96 && velocidadReal <= 1.02) {
                velocidadReal = 0.99;
            } else if (velocidadReal > 0.89 && velocidadReal <= 0.96) {
                velocidadReal = 0.92;
            } else if (velocidadReal > 0.82 && velocidadReal <= 0.89) {
                velocidadReal = 0.85;
            } else if (velocidadReal > 0.76 && velocidadReal <= 0.82) {
                velocidadReal = 0.79;
            } else if (velocidadReal > 0.69 && velocidadReal <= 0.76) {
                velocidadReal = 0.72;
            } else if (velocidadReal > 0.63 && velocidadReal <= 0.69) {
                velocidadReal = 0.66;
            } else if (velocidadReal > 0.56 && velocidadReal <= 0.63) {
                velocidadReal = 0.59;
            } else if (velocidadReal > 0.49 && velocidadReal <= 0.56) {
                velocidadReal = 0.52;
            } else if (velocidadReal > 0.43 && velocidadReal <= 0.49) {
                velocidadReal = 0.46;
            } else if (velocidadReal > 0.36 && velocidadReal <= 0.43) {
                velocidadReal = 0.39;
            } else if (velocidadReal <= 0.36) {
                velocidadReal = 0.33;
            }
        }
        return velocidadReal;
    }

}
