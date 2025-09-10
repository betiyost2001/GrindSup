package com.grindsup.backend.controller;

import com.grindsup.backend.model.Agenda;
import com.grindsup.backend.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping
    public List<Agenda> getAll() {
        return agendaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Agenda getById(@PathVariable int id) {
        return agendaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Agenda create(@RequestBody Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    @PutMapping("/{id}")
    public Agenda update(@PathVariable int id, @RequestBody Agenda agenda) {
        Agenda existing = agendaRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTurno(agenda.getTurno());
            existing.setEstado(agenda.getEstado());
            existing.setObservaciones(agenda.getObservaciones());
            existing.setCreated_at(agenda.getCreated_at());
            return agendaRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        agendaRepository.deleteById(id);
        return "Agenda eliminada con id " + id;
    }
}
