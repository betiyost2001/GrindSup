package com.grindsup.backend.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SesionesEntrenadores")
public class SesionEntrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sesion;

    @ManyToOne
    @JoinColumn(name = "id_entrenador", nullable = false)
    private Entrenador entrenador;

    private Timestamp inicio;
    private Timestamp fin;

    // Getters y Setters
    public int getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(int id_sesion) {
        this.id_sesion = id_sesion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Timestamp getInicio() {
        return inicio;
    }

    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }

    public Timestamp getFin() {
        return fin;
    }

    public void setFin(Timestamp fin) {
        this.fin = fin;
    }
}
