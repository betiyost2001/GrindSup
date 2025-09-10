package com.grindsup.backend.model;

import java.io.Serializable;
import java.util.Objects;

public class RutinaEjercicioId implements Serializable {

    private int rutina;
    private int ejercicio;

    // Constructor vacío
    public RutinaEjercicioId() {
    }

    public RutinaEjercicioId(int rutina, int ejercicio) {
        this.rutina = rutina;
        this.ejercicio = ejercicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RutinaEjercicioId))
            return false;
        RutinaEjercicioId that = (RutinaEjercicioId) o;
        return rutina == that.rutina && ejercicio == that.ejercicio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rutina, ejercicio);
    }
}
