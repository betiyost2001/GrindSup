package com.grindsup.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RutinaEjercicios")
@IdClass(RutinaEjercicioId.class)
public class RutinaEjercicio {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_rutina")
    private Rutina rutina;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_ejercicio")
    private Ejercicio ejercicio;

    private Integer series;
    private Integer repeticiones;
    private Integer duracion; // en minutos

    // Getters y Setters
    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
}
