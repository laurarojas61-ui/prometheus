package com.ev02prometheus.web.controller;

import com.ev02prometheus.web.model.Pago;
import com.ev02prometheus.web.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de pagos.
 */
@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    // Obtener todos los pagos
    @GetMapping
    public List<Pago> getAll() {
        return pagoService.findAll();
    }

    // Obtener un pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pago> getById(@PathVariable Long id) {
        return pagoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo pago
    @PostMapping
    public Pago create(@RequestBody Pago pago) {
        return pagoService.save(pago);
    }

    // Actualizar un pago
    @PutMapping("/{id}")
    public ResponseEntity<Pago> update(@PathVariable Long id, @RequestBody Pago pago) {
        return pagoService.findById(id)
                .map(existing -> {
                    pago.setId(id);
                    return ResponseEntity.ok(pagoService.save(pago));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (pagoService.findById(id).isPresent()) {
            pagoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}