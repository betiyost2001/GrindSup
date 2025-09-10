package com.grindsup.backend.controller;

import com.grindsup.backend.model.Entrenador;
import com.grindsup.backend.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @GetMapping
    public List<Entrenador> getAll() {
        return entrenadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Entrenador getById(@PathVariable int id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Entrenador create(@RequestBody Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    @PostMapping
    public Entrenador create(@RequestBody Entrenador entrenador) {
        entrenador.setCreated_at(new Timestamp(System.currentTimeMillis()));
        return entrenadorRepository.save(entrenador);
    }

    @PutMapping("/{id}")
    public Entrenador update(@PathVariable int id, @RequestBody Entrenador entrenador) {
        Entrenador existing = entrenadorRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNombre(entrenador.getNombre());
            existing.setApellido(entrenador.getApellido());
            existing.setEmail(entrenador.getEmail());
            existing.setTelefono(entrenador.getTelefono());
            existing.setExperiencia(entrenador.getExperiencia());
            existing.setUsuario(entrenador.getUsuario());
            existing.setContraseña(entrenador.getContraseña());
            existing.setEstado(entrenador.getEstado()); // ya maneja id_estado correctamente
            return entrenadorRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        entrenadorRepository.deleteById(id);
        return "Entrenador eliminado con id " + id;
    }
}