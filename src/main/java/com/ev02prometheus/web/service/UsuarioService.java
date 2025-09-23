package com.ev02prometheus.web.service;

import com.ev02prometheus.web.model.Usuario;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio para Usuario.
 */
public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}