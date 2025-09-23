package com.ev02prometheus.web.serviceimpl;

import com.ev02prometheus.web.model.Alquiler;
import com.ev02prometheus.web.repository.AlquilerRepository;
import com.ev02prometheus.web.service.AlquilerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de Alquiler usando JPA Repository.
 */
@Service
public class AlquilerServiceImpl implements AlquilerService {

    private final AlquilerRepository alquilerRepository;

    public AlquilerServiceImpl(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @Override
    public List<Alquiler> findAll() {
        return alquilerRepository.findAll();
    }

    @Override
    public Optional<Alquiler> findById(Long id) {
        return alquilerRepository.findById(id);
    }

    @Override
    public Alquiler save(Alquiler alquiler) {
        return alquilerRepository.save(alquiler);
    }

    @Override
    public void deleteById(Long id) {
        alquilerRepository.deleteById(id);
    }
}