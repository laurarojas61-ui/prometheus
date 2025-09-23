package com.ev02prometheus.web.controller;

import com.ev02prometheus.web.model.Propiedad;
import com.ev02prometheus.web.service.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/propiedades")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    // Obtener todas las propiedades
    @GetMapping
    public List<Propiedad> listarTodas() {
        return propiedadService.findAll();
    }

    // Obtener propiedad por ID
    @GetMapping("/{id}")
    public ResponseEntity<Propiedad> obtenerPorId(@PathVariable Long id) {
        Optional<Propiedad> propiedad = propiedadService.findById(id);
        return propiedad.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear nueva propiedad
    @PostMapping
    public Propiedad crear(@RequestBody Propiedad propiedad) {
        return propiedadService.save(propiedad);
    }

    // Actualizar propiedad
    @PutMapping("/{id}")
    public ResponseEntity<Propiedad> actualizar(@PathVariable Long id, @RequestBody Propiedad propiedadDetalles) {
        Optional<Propiedad> propiedadOpt = propiedadService.findById(id);

        if (propiedadOpt.isPresent()) {
            Propiedad propiedad = propiedadOpt.get();
            propiedad.setNombre(propiedadDetalles.getNombre());
            propiedad.setDireccion(propiedadDetalles.getDireccion());
            propiedad.setDescripcion(propiedadDetalles.getDescripcion());
            propiedad.setRentado(propiedadDetalles.isRentado());

            return ResponseEntity.ok(propiedadService.save(propiedad));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar propiedad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Propiedad> propiedadOpt = propiedadService.findById(id);

        if (propiedadOpt.isPresent()) {
            propiedadService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}