package com.grindsup.backend.controller;

import com.grindsup.backend.model.Ejercicio;
import com.grindsup.backend.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @GetMapping
    public List<Ejercicio> getAll() {
        return ejercicioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ejercicio getById(@PathVariable int id) {
        return ejercicioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Ejercicio create(@RequestBody Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    @PutMapping("/{id}")
    public Ejercicio update(@PathVariable int id, @RequestBody Ejercicio ejercicio) {
        Ejercicio existing = ejercicioRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNombre(ejercicio.getNombre());
            existing.setDescripcion(ejercicio.getDescripcion());
            existing.setVideo_url(ejercicio.getVideo_url());
            return ejercicioRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        ejercicioRepository.deleteById(id);
        return "Ejercicio eliminado con id " + id;
    }
}
