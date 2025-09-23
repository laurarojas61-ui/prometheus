package com.ev02prometheus.web.controller;

import com.ev02prometheus.web.model.Perfil;
import com.ev02prometheus.web.service.PerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar la entidad Perfil.
 * Expone endpoints para realizar operaciones CRUD.
 */
@RestController
@RequestMapping("/api/perfiles")
public class PerfilController {

    private final PerfilService perfilService;

    // Inyección de dependencias vía constructor
    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    /**
     * Obtener todos los perfiles.
     * Endpoint: GET /api/perfiles
     */
    @GetMapping
    public List<Perfil> getAllPerfiles() {
        return perfilService.findAll();
    }

    /**
     * Buscar un perfil por ID.
     * Endpoint: GET /api/perfiles/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfilById(@PathVariable Long id) {
        Optional<Perfil> perfil = perfilService.findById(id);
        return perfil.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crear un nuevo perfil.
     * Endpoint: POST /api/perfiles
     */
    @PostMapping
    public Perfil createPerfil(@RequestBody Perfil perfil) {
        return perfilService.save(perfil);
    }

    /**
     * Actualizar un perfil existente.
     * Endpoint: PUT /api/perfiles/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Perfil> updatePerfil(@PathVariable Long id, @RequestBody Perfil perfilDetails) {
        return perfilService.findById(id).map(perfil -> {
            perfil.setNombre(perfilDetails.getNombre());
            perfil.setDocumento(perfilDetails.getDocumento());
            perfil.setTelefono(perfilDetails.getTelefono());
            perfil.setCorreo(perfilDetails.getCorreo());
            perfil.setContrasena(perfilDetails.getContrasena());
            perfil.setUpdatedAt(perfilDetails.getUpdatedAt());
            Perfil updatedPerfil = perfilService.save(perfil);
            return ResponseEntity.ok(updatedPerfil);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Eliminar un perfil por ID.
     * Endpoint: DELETE /api/perfiles/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfil(@PathVariable Long id) {
        if (perfilService.findById(id).isPresent()) {
            perfilService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}