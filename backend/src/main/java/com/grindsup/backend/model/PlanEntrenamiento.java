package com.grindsup.backend.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PlanesEntrenamiento")
public class PlanEntrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_plan;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    private String objetivo;
    private String tipo_entrenamiento;
    private Integer sesiones_por_semana;
    private Date fecha_inicio;
    private Date fecha_fin;

    // Getters y Setters
    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getTipo_entrenamiento() {
        return tipo_entrenamiento;
    }

    public void setTipo_entrenamiento(String tipo_entrenamiento) {
        this.tipo_entrenamiento = tipo_entrenamiento;
    }

    public Integer getSesiones_por_semana() {
        return sesiones_por_semana;
    }

    public void setSesiones_por_semana(Integer sesiones_por_semana) {
        this.sesiones_por_semana = sesiones_por_semana;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
