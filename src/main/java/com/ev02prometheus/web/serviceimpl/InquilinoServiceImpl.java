package com.ev02prometheus.web.serviceimpl;

import com.ev02prometheus.web.model.Inquilino;
import com.ev02prometheus.web.repository.InquilinoRepository;
import com.ev02prometheus.web.service.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz InquilinoService.
 * Se comunica con el repositorio JPA para acceder a la BD.
 */
@Service
public class InquilinoServiceImpl implements InquilinoService {

    @Autowired
    private InquilinoRepository inquilinoRepository;

    @Override
    public List<Inquilino> getAllInquilinos() {
        return inquilinoRepository.findAll();
    }

    @Override
    public Optional<Inquilino> getInquilinoById(Long id) {
        return inquilinoRepository.findById(id);
    }

    @Override
    public Inquilino saveInquilino(Inquilino inquilino) {
        return inquilinoRepository.save(inquilino);
    }

    @Override
    public void deleteInquilino(Long id) {
        inquilinoRepository.deleteById(id);
    }
}