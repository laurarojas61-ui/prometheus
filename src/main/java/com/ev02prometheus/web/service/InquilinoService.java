package com.ev02prometheus.web.service;

import com.ev02prometheus.web.model.Inquilino;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define el contrato de operaciones sobre Inquilinos.
 */
public interface InquilinoService {

    // Obtener todos los inquilinos
    List<Inquilino> getAllInquilinos();

    // Buscar un inquilino por su ID
    Optional<Inquilino> getInquilinoById(Long id);

    // Guardar o actualizar un inquilino
    Inquilino saveInquilino(Inquilino inquilino);

    // Eliminar un inquilino por ID
    void deleteInquilino(Long id);
}