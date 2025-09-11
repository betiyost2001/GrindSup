package com.grindsup.backend.controller;

import com.grindsup.backend.model.PlanEntrenamiento;
import com.grindsup.backend.model.Alumno;
import com.grindsup.backend.model.Estado;
import com.grindsup.backend.repository.PlanEntrenamientoRepository;
import com.grindsup.backend.repository.AlumnoRepository;
import com.grindsup.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlanEntrenamientoController {

    @Autowired
    private PlanEntrenamientoRepository planRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<PlanEntrenamiento> getAll() {
        return planRepository.findAll();
    }

    @GetMapping("/{id}")
    public PlanEntrenamiento getById(@PathVariable Long id) {
        return planRepository.findById(id).orElse(null);
    }

    @PostMapping
    public PlanEntrenamiento create(@RequestBody PlanEntrenamiento plan) {
        if (plan.getAlumno() != null) {
            Alumno alumno = alumnoRepository.findById(plan.getAlumno().getId_alumno()).orElse(null);
            plan.setAlumno(alumno);
        }
        if (plan.getEstado() != null) {
            Estado estado = estadoRepository.findById(plan.getEstado().getId_estado()).orElse(null);
            plan.setEstado(estado);
        }
        return planRepository.save(plan);
    }

    @PutMapping("/{id}")
    public PlanEntrenamiento update(@PathVariable Long id, @RequestBody PlanEntrenamiento plan) {
        return planRepository.findById(id).map(existing -> {
            existing.setObjetivo(plan.getObjetivo());
            existing.setFecha_inicio(plan.getFecha_inicio());
            existing.setFecha_fin(plan.getFecha_fin());

            if (plan.getAlumno() != null) {
                Alumno alumno = alumnoRepository.findById(plan.getAlumno().getId_alumno()).orElse(null);
                existing.setAlumno(alumno);
            }
            if (plan.getEstado() != null) {
                Estado estado = estadoRepository.findById(plan.getEstado().getId_estado()).orElse(null);
                existing.setEstado(estado);
            }

            return planRepository.save(existing);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        planRepository.deleteById(id);
        return "Plan eliminado con id " + id;
    }
}
