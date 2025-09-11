package com.grindsup.backend.model;

import java.io.Serializable;
import java.util.Objects;

public class RutinaEjercicioId implements Serializable {

    private Long id_rutina;
    private Long id_ejercicio;

    public RutinaEjercicioId() {
    }

    public RutinaEjercicioId(Long id_rutina, Long id_ejercicio) {
        this.id_rutina = id_rutina;
        this.id_ejercicio = id_ejercicio;
    }

    public Long getId_rutina() {
        return id_rutina;
    }

    public void setId_rutina(Long id_rutina) {
        this.id_rutina = id_rutina;
    }

    public Long getId_ejercicio() {
        return id_ejercicio;
    }

    public void setId_ejercicio(Long id_ejercicio) {
        this.id_ejercicio = id_ejercicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RutinaEjercicioId))
            return false;
        RutinaEjercicioId that = (RutinaEjercicioId) o;
        return Objects.equals(id_rutina, that.id_rutina) &&
                Objects.equals(id_ejercicio, that.id_ejercicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_rutina, id_ejercicio);
    }
}
