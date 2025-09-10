package com.grindsup.backend.controller;

import com.grindsup.backend.model.Alumno;
import com.grindsup.backend.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Alumno getById(@PathVariable int id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Alumno create(@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumno update(@PathVariable int id, @RequestBody Alumno alumno) {
        Alumno existing = alumnoRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNombre(alumno.getNombre());
            existing.setApellido(alumno.getApellido());
            existing.setEdad(alumno.getEdad());
            existing.setPeso(alumno.getPeso());
            existing.setAltura(alumno.getAltura());
            existing.setOcupacion(alumno.getOcupacion());
            existing.setObjetivos(alumno.getObjetivos());
            existing.setEnfermedades(alumno.getEnfermedades());
            existing.setLesiones(alumno.getLesiones());
            existing.setMedicacion(alumno.getMedicacion());
            existing.setHabitos_sueño(alumno.getHabitos_sueño());
            existing.setHabitos_alimenticios(alumno.getHabitos_alimenticios());
            existing.setNivel_estres(alumno.getNivel_estres());
            existing.setObservaciones(alumno.getObservaciones());
            existing.setImc(alumno.getImc());
            existing.setEntrenador(alumno.getEntrenador());
            return alumnoRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        alumnoRepository.deleteById(id);
        return "Alumno eliminado con id " + id;
    }
}
