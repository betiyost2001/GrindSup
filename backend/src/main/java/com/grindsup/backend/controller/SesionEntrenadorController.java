package com.grindsup.backend.controller;

import com.grindsup.backend.model.SesionEntrenador;
import com.grindsup.backend.repository.SesionEntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sesiones")
public class SesionEntrenadorController {

    @Autowired
    private SesionEntrenadorRepository sesionRepository;

    @GetMapping
    public List<SesionEntrenador> getAll() {
        return sesionRepository.findAll();
    }

    @GetMapping("/{id}")
    public SesionEntrenador getById(@PathVariable int id) {
        return sesionRepository.findById(id).orElse(null);
    }

    @PostMapping
    public SesionEntrenador create(@RequestBody SesionEntrenador sesion) {
        return sesionRepository.save(sesion);
    }

    @PutMapping("/{id}")
    public SesionEntrenador update(@PathVariable int id, @RequestBody SesionEntrenador sesion) {
        SesionEntrenador existing = sesionRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setEntrenador(sesion.getEntrenador());
            existing.setInicio(sesion.getInicio());
            existing.setFin(sesion.getFin());
            return sesionRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        sesionRepository.deleteById(id);
        return "SesionEntrenador eliminada con id " + id;
    }
}
