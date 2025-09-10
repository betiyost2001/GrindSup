package com.grindsup.backend.controller;

import com.grindsup.backend.model.Rutina;
import com.grindsup.backend.repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutinas")
public class RutinaController {

    @Autowired
    private RutinaRepository rutinaRepository;

    @GetMapping
    public List<Rutina> getAll() {
        return rutinaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rutina getById(@PathVariable int id) {
        return rutinaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Rutina create(@RequestBody Rutina rutina) {
        return rutinaRepository.save(rutina);
    }

    @PutMapping("/{id}")
    public Rutina update(@PathVariable int id, @RequestBody Rutina rutina) {
        Rutina existing = rutinaRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNombre(rutina.getNombre());
            existing.setDescripcion(rutina.getDescripcion());
            existing.setPlan(rutina.getPlan());
            return rutinaRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        rutinaRepository.deleteById(id);
        return "Rutina eliminada con id " + id;
    }
}
