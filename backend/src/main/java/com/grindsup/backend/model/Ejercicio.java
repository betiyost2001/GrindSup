package com.grindsup.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Ejercicios")
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ejercicio;

    private String nombre;
    private String descripcion;
    private String video_url;

    // Getters y Setters
    public int getId_ejercicio() {
        return id_ejercicio;
    }

    public void setId_ejercicio(int id_ejercicio) {
        this.id_ejercicio = id_ejercicio;
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

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
}
