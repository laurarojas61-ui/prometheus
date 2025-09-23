package com.ev02prometheus.web.service;

import com.ev02prometheus.web.model.Alquiler;
import com.ev02prometheus.web.model.Inquilino;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface DashboardService {
    List<Alquiler> listarAlquileres(Boolean activo, LocalDate fechaInicio, LocalDate fechaFin);
    List<Inquilino> listarInquilinos();
    BigDecimal calcularTotalMonto(List<Alquiler> alquileres);
}
