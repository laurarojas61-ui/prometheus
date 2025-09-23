package com.ev02prometheus.web.serviceimpl;

import com.ev02prometheus.web.model.Usuario;
import com.ev02prometheus.web.repository.UsuarioRepository;
import com.ev02prometheus.web.service.LoginService;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String correo, String contraseña, HttpSession session) {
        Optional<Usuario> usuario = usuarioRepository.findByCorreo(correo);
        if (usuario.isPresent() && usuario.get().getContraseña().equals(contraseña)) {
            session.setAttribute("usuario", usuario.get());
            return usuario;
        }
        return Optional.empty();
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }
}