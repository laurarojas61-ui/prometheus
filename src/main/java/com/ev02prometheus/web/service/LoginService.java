package com.ev02prometheus.web.service;

import com.ev02prometheus.web.model.Usuario;
import java.util.Optional;

public interface LoginService {
    Optional<Usuario> login(String correo, String contraseña, jakarta.servlet.http.HttpSession session);
    void logout(jakarta.servlet.http.HttpSession session);
}