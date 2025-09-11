package com.grindsup.backend.controller;

import com.grindsup.backend.model.TipoTurno;
import com.grindsup.backend.repository.TipoTurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-turno")
public class TipoTurnoController {

    @Autowired
    private TipoTurnoRepository repository;

    @GetMapping
    public List<TipoTurno> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public TipoTurno getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public TipoTurno create(@RequestBody TipoTurno tipoTurno) {
        return repository.save(tipoTurno);
    }

    @PutMapping("/{id}")
    public TipoTurno update(@PathVariable Long id, @RequestBody TipoTurno tipoTurno) {
        return repository.findById(id).map(existing -> {
            existing.setNombre(tipoTurno.getNombre());
            existing.setDescripcion(tipoTurno.getDescripcion());
            return repository.save(existing);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "TipoTurno eliminado con id " + id;
    }
}
