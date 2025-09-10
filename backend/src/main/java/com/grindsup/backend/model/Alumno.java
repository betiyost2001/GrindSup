package com.grindsup.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_alumno;

    @ManyToOne
    @JoinColumn(name = "id_entrenador", nullable = false)
    private Entrenador entrenador;

    private String nombre;
    private String apellido;
    private Integer edad;
    private BigDecimal peso;
    private BigDecimal altura;
    private String ocupacion;
    private String objetivos;
    private String enfermedades;
    private String lesiones;
    private String medicacion;
    private String habitos_sueño;
    private String habitos_alimenticios;
    private String nivel_estres;
    private String observaciones;
    private BigDecimal imc;

    @Column(name = "created_at")
    private Timestamp created_at;

    // Getters y Setters
    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getLesiones() {
        return lesiones;
    }

    public void setLesiones(String lesiones) {
        this.lesiones = lesiones;
    }

    public String getMedicacion() {
        return medicacion;
    }

    public void setMedicacion(String medicacion) {
        this.medicacion = medicacion;
    }

    public String getHabitos_sueño() {
        return habitos_sueño;
    }

    public void setHabitos_sueño(String habitos_sueño) {
        this.habitos_sueño = habitos_sueño;
    }

    public String getHabitos_alimenticios() {
        return habitos_alimenticios;
    }

    public void setHabitos_alimenticios(String habitos_alimenticios) {
        this.habitos_alimenticios = habitos_alimenticios;
    }

    public String getNivel_estres() {
        return nivel_estres;
    }

    public void setNivel_estres(String nivel_estres) {
        this.nivel_estres = nivel_estres;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getImc() {
        return imc;
    }

    public void setImc(BigDecimal imc) {
        this.imc = imc;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
