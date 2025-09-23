package com.ev02prometheus.web.serviceimpl;

import com.ev02prometheus.web.model.Pago;
import com.ev02prometheus.web.repository.PagoRepository;
import com.ev02prometheus.web.service.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de Pago usando JPA Repository.
 */
@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    public PagoServiceImpl(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> findById(Long id) {
        return pagoRepository.findById(id);
    }

    @Override
    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public void deleteById(Long id) {
        pagoRepository.deleteById(id);
    }
}