package com.ev02prometheus.web.service;

import com.ev02prometheus.web.model.Pago;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del servicio de Pago.
 */
public interface PagoService {
    List<Pago> findAll();
    Optional<Pago> findById(Long id);
    Pago save(Pago pago);
    void deleteById(Long id);
}
