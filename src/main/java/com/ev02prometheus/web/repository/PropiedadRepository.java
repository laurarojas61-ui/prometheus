package com.ev02prometheus.web.repository;

import com.ev02prometheus.web.model.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para gestionar la entidad Propiedad.
 */
@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
}