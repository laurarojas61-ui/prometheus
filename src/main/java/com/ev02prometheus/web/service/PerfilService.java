package com.ev02prometheus.web.service;

import com.ev02prometheus.web.model.Perfil;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz del servicio para la entidad Perfil.
 * Define las operaciones de negocio que se pueden realizar.
 */
public interface PerfilService {

    /**
     * Obtiene todos los perfiles registrados.
     */
    List<Perfil> findAll();

    /**
     * Busca un perfil por su ID.
     */
    Optional<Perfil> findById(Long id);

    /**
     * Guarda un nuevo perfil o actualiza uno existente.
     */
    Perfil save(Perfil perfil);

    /**
     * Elimina un perfil por su ID.
     */
    void deleteById(Long id);
}