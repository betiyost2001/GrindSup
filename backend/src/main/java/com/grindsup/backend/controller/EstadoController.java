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
    public Estado getById(@PathVariable int id) {
        return estadoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Estado create(@RequestBody Estado estado) {
        return estadoRepository.save(estado);
    }

    @PutMapping("/{id}")
    public Estado update(@PathVariable int id, @RequestBody Estado estado) {
        Estado existing = estadoRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNombre(estado.getNombre());
            existing.setDescripcion(estado.getDescripcion());
            return estadoRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        estadoRepository.deleteById(id);
        return "Estado eliminado con id " + id;
    }
}
