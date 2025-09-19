package com.grindsup.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TestController {

    @GetMapping("/test")
    public Map<String, Object> test() {
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Backend funcionando con MySQL!");
        response.put("estado", "OK");
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Bienvenido a la API de GrindSup");
        response.put("endpoints_disponibles", new String[] {
                "/test - Para probar la conexión",
                "/api/ejercicios - CRUD de ejercicios",
                "/api/alumnos - CRUD de alumnos",
                "/api/entrenadores - CRUD de entrenadores"
        });
        return response;
    }

    @GetMapping("/status")
    public Map<String, Object> status() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("database", "Connected");
        response.put("version", "1.0.0");
        return response;
    }
}