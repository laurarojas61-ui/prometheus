package com.ev02prometheus.web.serviceimpl;

import com.ev02prometheus.web.model.Alquiler;
import com.ev02prometheus.web.model.Inquilino;
import com.ev02prometheus.web.repository.AlquilerRepository;
import com.ev02prometheus.web.repository.InquilinoRepository;
import com.ev02prometheus.web.service.DashboardService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final AlquilerRepository alquilerRepository;
    private final InquilinoRepository inquilinoRepository;

    public DashboardServiceImpl(AlquilerRepository alquilerRepository, InquilinoRepository inquilinoRepository) {
        this.alquilerRepository = alquilerRepository;
        this.inquilinoRepository = inquilinoRepository;
    }

    @Override
    public List<Alquiler> listarAlquileres(Boolean activo, LocalDate fechaInicio, LocalDate fechaFin) {
        return alquilerRepository.findAll().stream()
                .filter(a -> (activo == null || a.isActivo() == activo))
                .filter(a -> (fechaInicio == null || !a.getFechaInicio().isBefore(fechaInicio)))
                .filter(a -> (fechaFin == null || !a.getFechaFin().isAfter(fechaFin)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Inquilino> listarInquilinos() {
        return inquilinoRepository.findAll();
    }

    @Override
    public BigDecimal calcularTotalMonto(List<Alquiler> alquileres) {
        return alquileres.stream()
                .map(Alquiler::getMontoMensual)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
