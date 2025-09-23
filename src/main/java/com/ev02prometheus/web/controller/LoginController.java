package com.ev02prometheus.web.controller;

import com.ev02prometheus.web.model.Usuario;
import com.ev02prometheus.web.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales, HttpSession session) {
        String correo = credenciales.get("correo");
        String contraseña = credenciales.get("contraseña");

        // Llamada al servicio de login
        Optional<Usuario> usuarioOpt = loginService.login(correo, contraseña, session);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();  // Ahora se usa explícitamente la clase Usuario
            return ResponseEntity.ok(Map.of(
                    "mensaje", "Login exitoso",
                    "usuario", Map.of(
                            "id", usuario.getId(),
                            "nombre", usuario.getNombre(),
                            "correo", usuario.getCorreo()
                    )
            ));
        } else {
            return ResponseEntity.status(401).body(Map.of(
                    "error", "Correo o contraseña incorrectos"
            ));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        loginService.logout(session);
        return ResponseEntity.ok(Map.of("mensaje", "Sesión cerrada correctamente"));
    }
}