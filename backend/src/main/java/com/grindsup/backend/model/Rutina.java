package com.grindsup.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Rutinas")
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rutina;

    @ManyToOne
    @JoinColumn(name = "id_plan", nullable = false)
    private PlanEntrenamiento plan;

    private String nombre;
    private String descripcion;

    // Getters y Setters
    public int getId_rutina() {
        return id_rutina;
    }

    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }

    public PlanEntrenamiento getPlan() {
        return plan;
    }

    public void setPlan(PlanEntrenamiento plan) {
        this.plan = plan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
