package com.grindsup.backend.controller;

import com.grindsup.backend.model.Alumno;
import com.grindsup.backend.model.Entrenador;
import com.grindsup.backend.model.Estado;
import com.grindsup.backend.repository.AlumnoRepository;
import com.grindsup.backend.repository.EntrenadorRepository;
import com.grindsup.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

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
        if (alumno.getEntrenador() != null) {
            Entrenador entrenador = entrenadorRepository.findById(alumno.getEntrenador().getId_entrenador())
                    .orElse(null);
            alumno.setEntrenador(entrenador);
        }
        if (alumno.getEstado() != null) {
            Estado estado = estadoRepository.findById(alumno.getEstado().getId_estado()).orElse(null);
            alumno.setEstado(estado);
        }
        return alumnoRepository.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumno update(@PathVariable Long id, @RequestBody Alumno alumno) {
        return alumnoRepository.findById(id).map(existing -> {
            existing.setNombre(alumno.getNombre());
            existing.setApellido(alumno.getApellido());
            existing.setTelefono(alumno.getTelefono());

            if (alumno.getEntrenador() != null) {
                Entrenador entrenador = entrenadorRepository.findById(alumno.getEntrenador().getId_entrenador())
                        .orElse(null);
                existing.setEntrenador(entrenador);
            }
            if (alumno.getEstado() != null) {
                Estado estado = estadoRepository.findById(alumno.getEstado().getId_estado()).orElse(null);
                existing.setEstado(estado);
            }
            return alumnoRepository.save(existing);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        alumnoRepository.deleteById(id);
        return "Alumno eliminado con id " + id;
    }
}
