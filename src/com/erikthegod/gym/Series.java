/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym;

import java.util.ArrayList;

/**
 *
 * @author kinton
 */
public class Series {
    private int repeticiones;
    private int rmSerie;

    public Series(int repeticiones, int rmSerie) {
        this.repeticiones = repeticiones;
        this.rmSerie = rmSerie;
    }  

    public int getRmSerie() {
        return rmSerie;
    }

    public int getRepeticiones() {
        return repeticiones;
    }
    
}
