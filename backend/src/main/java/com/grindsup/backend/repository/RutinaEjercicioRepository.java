package com.grindsup.backend.repository;

import com.grindsup.backend.model.RutinaEjercicio;
import com.grindsup.backend.model.RutinaEjercicioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RutinaEjercicioRepository extends JpaRepository<RutinaEjercicio, RutinaEjercicioId> {
}
