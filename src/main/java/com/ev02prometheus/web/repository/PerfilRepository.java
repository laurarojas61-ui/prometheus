package com.ev02prometheus.web.repository;

import com.ev02prometheus.web.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Perfil.
 */
@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
