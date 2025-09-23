package com.ev02prometheus.web.service;

import com.ev02prometheus.web.model.Propiedad;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz del servicio de Property.
 */
public interface PropiedadService {
    List<Propiedad> findAll();
    Optional<Propiedad> findById(Long id);
    Propiedad save(Propiedad property);
    void deleteById(Long id);
}