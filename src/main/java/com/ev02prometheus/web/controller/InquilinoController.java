package com.ev02prometheus.web.controller;

import com.ev02prometheus.web.model.Inquilino;
import com.ev02prometheus.web.service.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar los endpoints de Inquilinos.
 * Maneja las operaciones CRUD a través de HTTP.
 */
@RestController
@RequestMapping("/api/inquilinos")
public class InquilinoController {

    @Autowired
    private InquilinoService inquilinoService;

    /**
     * Obtener todos los inquilinos.
     */
    @GetMapping
    public List<Inquilino> getAllInquilinos() {
        return inquilinoService.getAllInquilinos();
    }

    /**
     * Buscar un inquilino por su ID.
     */
    @GetMapping("/{id}")
    public Optional<Inquilino> getInquilinoById(@PathVariable Long id) {
        return inquilinoService.getInquilinoById(id);
    }

    /**
     * Crear o actualizar un inquilino.
     */
    @PostMapping
    public Inquilino saveInquilino(@RequestBody Inquilino inquilino) {
        return inquilinoService.saveInquilino(inquilino);
    }

    /**
     * Eliminar un inquilino por ID.
     */
    @DeleteMapping("/{id}")
    public String deleteInquilino(@PathVariable Long id) {
        inquilinoService.deleteInquilino(id);
        return "Inquilino eliminado con ID: " + id;
    }
}
