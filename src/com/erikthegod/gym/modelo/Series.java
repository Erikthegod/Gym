package com.erikthegod.gym.modelo;

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
