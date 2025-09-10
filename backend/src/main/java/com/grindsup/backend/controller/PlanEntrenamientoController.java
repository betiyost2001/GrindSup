package com.grindsup.backend.controller;

import com.grindsup.backend.model.PlanEntrenamiento;
import com.grindsup.backend.repository.PlanEntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlanEntrenamientoController {

    @Autowired
    private PlanEntrenamientoRepository planRepository;

    @GetMapping
    public List<PlanEntrenamiento> getAll() {
        return planRepository.findAll();
    }

    @GetMapping("/{id}")
    public PlanEntrenamiento getById(@PathVariable int id) {
        return planRepository.findById(id).orElse(null);
    }

    @PostMapping
    public PlanEntrenamiento create(@RequestBody PlanEntrenamiento plan) {
        return planRepository.save(plan);
    }

    @PutMapping("/{id}")
    public PlanEntrenamiento update(@PathVariable int id, @RequestBody PlanEntrenamiento plan) {
        PlanEntrenamiento existing = planRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setObjetivo(plan.getObjetivo());
            existing.setTipo_entrenamiento(plan.getTipo_entrenamiento());
            existing.setSesiones_por_semana(plan.getSesiones_por_semana());
            existing.setFecha_inicio(plan.getFecha_inicio());
            existing.setFecha_fin(plan.getFecha_fin());
            existing.setAlumno(plan.getAlumno());
            return planRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        planRepository.deleteById(id);
        return "Plan eliminado con id " + id;
    }
}
