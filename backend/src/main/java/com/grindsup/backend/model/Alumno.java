package com.grindsup.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "alumnos") // 🚩 Aclaración: usamos "alumnos" (plural) porque así está en la DB
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alumno;

    // 🚩 CAMBIO: Relación con Entrenador, pero puede ser NULL (nullable = true)
    // porque todavía no lo asignamos al crear/editar desde el Controller
    @ManyToOne
    @JoinColumn(name = "id_entrenador", nullable = true)
    private Entrenador entrenador;

    @Column(nullable = false, length = 100)
    private String nombre; // requerido

    @Column(length = 100)
    private String apellido; // opcional

    // 🚩 CAMBIO: Documento agregado como campo obligatorio y UNIQUE
    // evita duplicados y es usado en el backend para validar
    @Column(nullable = false, length = 20, unique = true)
    private String documento;

    // 🚩 CAMBIO: Teléfono opcional (el front lo manda como "contacto")
    @Column(length = 50)
    private String telefono;

    // 🚩 CAMBIO: Agregamos fecha de nacimiento
    // Se guarda como DATE y se formatea en JSON como yyyy-MM-dd
    @Column(name = "fecha_nacimiento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    // 🚩 CAMBIO: Nuevos campos físicos
    @Column
    private Double peso;   // opcional

    @Column
    private Double altura; // opcional

    // 🚩 CAMBIO: Historial de lesiones, tipo TEXT para permitir texto largo
    @Column(columnDefinition = "TEXT")
    private String lesiones;

    // Relación con la tabla estados (id_estado)
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    // Auditoría: timestamps para altas, modificaciones y bajas lógicas
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime created_at;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updated_at;

    @Column(name = "deleted_at")
    private OffsetDateTime deleted_at;

    // Getters y Setters (generados por Lombok en otros proyectos, acá manuales)
    public Long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getLesiones() {
        return lesiones;
    }

    public void setLesiones(String lesiones) {
        this.lesiones = lesiones;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(OffsetDateTime created_at) {
        this.created_at = created_at;
    }

    public OffsetDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(OffsetDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public OffsetDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(OffsetDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }
}
