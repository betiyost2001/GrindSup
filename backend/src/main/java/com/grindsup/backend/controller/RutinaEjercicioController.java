package com.grindsup.backend.controller;

import com.grindsup.backend.model.RutinaEjercicio;
import com.grindsup.backend.model.RutinaEjercicioId;
import com.grindsup.backend.repository.RutinaEjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutina-ejercicios")
public class RutinaEjercicioController {

    @Autowired
    private RutinaEjercicioRepository rutinaEjercicioRepository;

    @GetMapping
    public List<RutinaEjercicio> getAll() {
        return rutinaEjercicioRepository.findAll();
    }

    @GetMapping("/{rutinaId}/{ejercicioId}")
    public RutinaEjercicio getById(@PathVariable int rutinaId, @PathVariable int ejercicioId) {
        return rutinaEjercicioRepository.findById(new RutinaEjercicioId(rutinaId, ejercicioId)).orElse(null);
    }

    @PostMapping
    public RutinaEjercicio create(@RequestBody RutinaEjercicio rutinaEjercicio) {
        return rutinaEjercicioRepository.save(rutinaEjercicio);
    }

    @PutMapping("/{rutinaId}/{ejercicioId}")
    public RutinaEjercicio update(@PathVariable int rutinaId, @PathVariable int ejercicioId,
            @RequestBody RutinaEjercicio rutinaEjercicio) {
        RutinaEjercicioId id = new RutinaEjercicioId(rutinaId, ejercicioId);
        RutinaEjercicio existing = rutinaEjercicioRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setSeries(rutinaEjercicio.getSeries());
            existing.setRepeticiones(rutinaEjercicio.getRepeticiones());
            existing.setDuracion(rutinaEjercicio.getDuracion());
            existing.setRutina(rutinaEjercicio.getRutina());
            existing.setEjercicio(rutinaEjercicio.getEjercicio());
            return rutinaEjercicioRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{rutinaId}/{ejercicioId}")
    public String delete(@PathVariable int rutinaId, @PathVariable int ejercicioId) {
        rutinaEjercicioRepository.deleteById(new RutinaEjercicioId(rutinaId, ejercicioId));
        return "RutinaEjercicio eliminada con id [" + rutinaId + ", " + ejercicioId + "]";
    }
}
