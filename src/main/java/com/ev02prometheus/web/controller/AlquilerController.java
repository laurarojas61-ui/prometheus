package com.ev02prometheus.web.controller;

import com.ev02prometheus.web.model.Alquiler;
import com.ev02prometheus.web.service.AlquilerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar alquileres.
 */
@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {

    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    // Obtener todos los alquileres
    @GetMapping
    public ResponseEntity<List<Alquiler>> getAll() {
        return ResponseEntity.ok(alquilerService.findAll());
    }

    // Obtener alquiler por ID
    @GetMapping("/{id}")
    public ResponseEntity<Alquiler> getById(@PathVariable Long id) {
        Optional<Alquiler> alquiler = alquilerService.findById(id);
        return alquiler.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo alquiler
    @PostMapping
    public ResponseEntity<Alquiler> create(@RequestBody Alquiler alquiler) {
        Alquiler saved = alquilerService.save(alquiler);
        return ResponseEntity.ok(saved);
    }

    // Actualizar alquiler
    @PutMapping("/{id}")
    public ResponseEntity<Alquiler> update(@PathVariable Long id, @RequestBody Alquiler alquiler) {
        Optional<Alquiler> existing = alquilerService.findById(id);
        if (existing.isPresent()) {
            alquiler.setId(id); // asegurar que se actualiza el correcto
            Alquiler updated = alquilerService.save(alquiler);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar alquiler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Alquiler> existing = alquilerService.findById(id);
        if (existing.isPresent()) {
            alquilerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}