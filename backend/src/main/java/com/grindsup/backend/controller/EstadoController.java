package com.grindsup.backend.controller;

import com.grindsup.backend.model.Estado;
import com.grindsup.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Estado> getAll() {
        return estadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Estado getById(@PathVariable Long id) {
        return estadoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Estado create(@RequestBody Estado estado) {
        return estadoRepository.save(estado);
    }

    @PutMapping("/{id}")
    public Estado update(@PathVariable Long id, @RequestBody Estado estado) {
        return estadoRepository.findById(id).map(existing -> {
            existing.setNombre(estado.getNombre());
            existing.setDescripcion(estado.getDescripcion());
            existing.setAmbito(estado.getAmbito());
            return estadoRepository.save(existing);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        estadoRepository.deleteById(id);
        return "Estado eliminado con id " + id;
    }
}
