package com.ev02prometheus.web.service;

import com.ev02prometheus.web.model.Alquiler;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz del servicio para Alquileres.
 */
public interface AlquilerService {
    List<Alquiler> findAll();
    Optional<Alquiler> findById(Long id);
    Alquiler save(Alquiler alquiler);
    void deleteById(Long id);
}