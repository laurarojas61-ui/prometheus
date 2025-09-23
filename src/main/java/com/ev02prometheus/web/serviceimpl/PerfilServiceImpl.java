package com.ev02prometheus.web.serviceimpl;

import com.ev02prometheus.web.model.Perfil;
import com.ev02prometheus.web.repository.PerfilRepository;
import com.ev02prometheus.web.service.PerfilService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de Perfil usando JPA Repository.
 */
@Service
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilServiceImpl(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    @Override
    public Optional<Perfil> findById(Long id) {
        return perfilRepository.findById(id);
    }

    @Override
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public void deleteById(Long id) {
        perfilRepository.deleteById(id);
    }
}