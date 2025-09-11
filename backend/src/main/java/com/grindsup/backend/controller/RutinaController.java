package com.grindsup.backend.controller;

import com.grindsup.backend.model.Rutina;
import com.grindsup.backend.model.PlanEntrenamiento;
import com.grindsup.backend.model.Estado;
import com.grindsup.backend.repository.RutinaRepository;
import com.grindsup.backend.repository.PlanEntrenamientoRepository;
import com.grindsup.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutinas")
public class RutinaController {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private PlanEntrenamientoRepository planRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Rutina> getAll() {
        return rutinaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rutina getById(@PathVariable Long id) {
        return rutinaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Rutina create(@RequestBody Rutina rutina) {
        if (rutina.getPlan() != null) {
            PlanEntrenamiento plan = planRepository.findById(rutina.getPlan().getId_plan()).orElse(null);
            rutina.setPlan(plan);
        }
        if (rutina.getEstado() != null) {
            Estado estado = estadoRepository.findById(rutina.getEstado().getId_estado()).orElse(null);
            rutina.setEstado(estado);
        }
        return rutinaRepository.save(rutina);
    }

    @PutMapping("/{id}")
    public Rutina update(@PathVariable Long id, @RequestBody Rutina rutina) {
        return rutinaRepository.findById(id).map(existing -> {
            existing.setNombre(rutina.getNombre());
            existing.setDescripcion(rutina.getDescripcion());

            if (rutina.getPlan() != null) {
                PlanEntrenamiento plan = planRepository.findById(rutina.getPlan().getId_plan()).orElse(null);
                existing.setPlan(plan);
            }
            if (rutina.getEstado() != null) {
                Estado estado = estadoRepository.findById(rutina.getEstado().getId_estado()).orElse(null);
                existing.setEstado(estado);
            }
            return rutinaRepository.save(existing);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        rutinaRepository.deleteById(id);
        return "Rutina eliminada con id " + id;
    }
}
