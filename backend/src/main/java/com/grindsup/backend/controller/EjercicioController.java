package com.grindsup.backend.controller;

import com.grindsup.backend.model.Ejercicio;
import com.grindsup.backend.model.Estado;
import com.grindsup.backend.repository.EjercicioRepository;
import com.grindsup.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Ejercicio> getAll() {
        return ejercicioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ejercicio getById(@PathVariable Long id) {
        return ejercicioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Ejercicio create(@RequestBody Ejercicio ejercicio) {
        if (ejercicio.getEstado() != null) {
            Estado estado = estadoRepository.findById(ejercicio.getEstado().getId_estado()).orElse(null);
            ejercicio.setEstado(estado);
        }
        return ejercicioRepository.save(ejercicio);
    }

    @PutMapping("/{id}")
    public Ejercicio update(@PathVariable Long id, @RequestBody Ejercicio ejercicio) {
        return ejercicioRepository.findById(id).map(existing -> {
            existing.setNombre(ejercicio.getNombre());
            existing.setDescripcion(ejercicio.getDescripcion());
            if (ejercicio.getEstado() != null) {
                Estado estado = estadoRepository.findById(ejercicio.getEstado().getId_estado()).orElse(null);
                existing.setEstado(estado);
            }
            return ejercicioRepository.save(existing);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        ejercicioRepository.deleteById(id);
        return "Ejercicio eliminado con id " + id;
    }
}
