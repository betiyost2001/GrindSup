package com.grindsup.backend.controller;

import com.grindsup.backend.model.Turno;
import com.grindsup.backend.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoRepository turnoRepository;

    @GetMapping
    public List<Turno> getAll() {
        return turnoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Turno getById(@PathVariable int id) {
        return turnoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Turno create(@RequestBody Turno turno) {
        return turnoRepository.save(turno);
    }

    @PutMapping("/{id}")
    public Turno update(@PathVariable int id, @RequestBody Turno turno) {
        Turno existing = turnoRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setEntrenador(turno.getEntrenador());
            existing.setAlumno(turno.getAlumno());
            existing.setFecha(turno.getFecha());
            existing.setHora_inicio(turno.getHora_inicio());
            existing.setHora_fin(turno.getHora_fin());
            existing.setTipo(turno.getTipo());
            existing.setEstado(turno.getEstado());
            return turnoRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        turnoRepository.deleteById(id);
        return "Turno eliminado con id " + id;
    }
}
