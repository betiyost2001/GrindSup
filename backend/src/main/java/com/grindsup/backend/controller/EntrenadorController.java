package com.grindsup.backend.controller;

import com.grindsup.backend.model.Entrenador;
import com.grindsup.backend.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    // GET todos los entrenadores
    @GetMapping
    public List<Entrenador> getAll() {
        return entrenadorRepository.findAll();
    }

    // GET un entrenador por id
    @GetMapping("/{id}")
    public Entrenador getById(@PathVariable Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    // POST crear nuevo entrenador
    @PostMapping
    public Entrenador create(@RequestBody Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    // PUT actualizar entrenador
    @PutMapping("/{id}")
    public Entrenador update(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        Entrenador existing = entrenadorRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNombre(entrenador.getNombre());
            existing.setApellido(entrenador.getApellido());
            existing.setEmail(entrenador.getEmail());
            existing.setTelefono(entrenador.getTelefono());
            existing.setExperiencia(entrenador.getExperiencia());
            existing.setUsuario(entrenador.getUsuario());
            existing.setContraseña(entrenador.getContraseña());
            existing.setEstado(entrenador.getEstado());
            return entrenadorRepository.save(existing);
        }
        return null;
    }

    // DELETE eliminar entrenador
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        entrenadorRepository.deleteById(id);
        return "Entrenador eliminado con id " + id;
    }
}
