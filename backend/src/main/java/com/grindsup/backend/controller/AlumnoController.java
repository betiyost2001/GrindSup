package com.grindsup.backend.controller;

import com.grindsup.backend.model.Alumno;
import com.grindsup.backend.model.Estado;
import com.grindsup.backend.repository.AlumnoRepository;
import com.grindsup.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Alumno getById(@PathVariable Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Alumno create(@RequestBody Alumno alumno) {
        // Estado por defecto = 1 (si existe); si no existe, queda null y permite guardar
        Estado estadoActivo = estadoRepository.findById(1L).orElse(null);
        alumno.setEstado(estadoActivo);

        // Entrenador aún no implementado → lo dejamos en null
        alumno.setEntrenador(null);

        // Timestamps obligatorios
        OffsetDateTime ahora = OffsetDateTime.now();
        alumno.setCreated_at(ahora);
        alumno.setUpdated_at(ahora);

        // Limpieza mínima de strings
        if (alumno.getNombre() != null) alumno.setNombre(alumno.getNombre().trim());
        if (alumno.getApellido() != null) alumno.setApellido(alumno.getApellido().trim());
        if (alumno.getDocumento() != null) alumno.setDocumento(alumno.getDocumento().trim());
        if (alumno.getTelefono() != null) alumno.setTelefono(alumno.getTelefono().trim());

        try {
            return alumnoRepository.save(alumno);
        } catch (DataIntegrityViolationException ex) {
            // p.ej. documento duplicado (UNIQUE)
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "No se pudo crear el alumno (verificá si el documento ya existe).",
                ex
            );
        }
    }

    @PutMapping("/{id}")
    public Alumno update(@PathVariable Long id, @RequestBody Alumno alumno) {
        return alumnoRepository.findById(id).map(existing -> {
            // Campos simples
            existing.setNombre(alumno.getNombre());
            existing.setApellido(alumno.getApellido());
            existing.setDocumento(alumno.getDocumento());
            existing.setTelefono(alumno.getTelefono());
            existing.setFechaNacimiento(alumno.getFechaNacimiento());
            existing.setPeso(alumno.getPeso());
            existing.setAltura(alumno.getAltura());
            existing.setLesiones(alumno.getLesiones());

            // Entrenador: seguimos dejándolo en null hasta implementar esa parte
            existing.setEntrenador(null);

            // Estado: si viene en el request con id válido, lo actualizo; si no, dejo el actual
            if (alumno.getEstado() != null) {
                Long estadoId = alumno.getEstado().getId_estado(); // ajustado a tu entidad Estado
                if (estadoId != null) {
                    Estado nuevoEstado = estadoRepository.findById(estadoId).orElse(existing.getEstado());
                    existing.setEstado(nuevoEstado);
                }
            }

            // Timestamp de modificación
            existing.setUpdated_at(OffsetDateTime.now());

            try {
                return alumnoRepository.save(existing);
            } catch (DataIntegrityViolationException ex) {
                throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "No se pudo actualizar el alumno (verificá si el documento ya existe).",
                    ex
                );
            }
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        alumnoRepository.deleteById(id);
        return "Alumno eliminado con id " + id;
    }
}
