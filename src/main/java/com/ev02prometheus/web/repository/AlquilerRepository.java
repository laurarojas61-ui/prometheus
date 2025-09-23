package com.ev02prometheus.web.repository;

import com.ev02prometheus.web.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
}