package com.ev02prometheus.web.repository;

import com.ev02prometheus.web.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Pago.
 * Ofrece operaciones CRUD usando Spring Data JPA.
 */
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}