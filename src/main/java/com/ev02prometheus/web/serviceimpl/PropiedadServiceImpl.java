package com.ev02prometheus.web.serviceimpl;

import com.ev02prometheus.web.model.Propiedad;
import com.ev02prometheus.web.repository.PropiedadRepository;
import com.ev02prometheus.web.service.PropiedadService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de Propiedad usando JPA Repository.
 */
@Service
public class PropiedadServiceImpl implements PropiedadService {  // implements, no extends

    private final PropiedadRepository propiedadRepository;

    public PropiedadServiceImpl(PropiedadRepository propiedadRepository) {
        this.propiedadRepository = propiedadRepository;
    }

    @Override
    public List<Propiedad> findAll() {
        return propiedadRepository.findAll();
    }

    @Override
    public Optional<Propiedad> findById(Long id) {
        return propiedadRepository.findById(id);
    }

    @Override
    public Propiedad save(Propiedad propiedad) {
        return propiedadRepository.save(propiedad);
    }

    @Override
    public void deleteById(Long id) {
        propiedadRepository.deleteById(id);
    }
}