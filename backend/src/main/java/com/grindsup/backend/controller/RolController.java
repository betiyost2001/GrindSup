package com.grindsup.backend.controller;

import com.grindsup.backend.model.Rol;
import com.grindsup.backend.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rol getById(@PathVariable Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Rol create(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }

    @PutMapping("/{id}")
    public Rol update(@PathVariable Long id, @RequestBody Rol rol) {
        return rolRepository.findById(id).map(existing -> {
            existing.setNombre(rol.getNombre());
            existing.setDescripcion(rol.getDescripcion());
            return rolRepository.save(existing);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        rolRepository.deleteById(id);
        return "Rol eliminado con id " + id;
    }
}
