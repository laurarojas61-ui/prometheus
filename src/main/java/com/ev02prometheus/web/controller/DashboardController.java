package com.ev02prometheus.web.controller;

import com.ev02prometheus.web.model.Alquiler;
import com.ev02prometheus.web.model.Inquilino;
import com.ev02prometheus.web.model.Usuario;
import com.ev02prometheus.web.service.DashboardService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public ResponseEntity<?> obtenerDashboard(
            HttpSession session,
            @RequestParam(required = false) Boolean activo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fi,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ff
    ) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return ResponseEntity.status(401).body(Map.of("error", "No hay sesión activa"));
        }

        List<Alquiler> alquileresFiltrados = dashboardService.listarAlquileres(activo, fi, ff);
        List<Inquilino> inquilinos = dashboardService.listarInquilinos();
        BigDecimal totalMonto = dashboardService.calcularTotalMonto(alquileresFiltrados);

        Map<String, Object> response = new HashMap<>();
        response.put("usuario", usuario.getNombre());
        response.put("totalMonto", totalMonto);
        response.put("alquileres", alquileresFiltrados);
        response.put("inquilinos", inquilinos);
        response.put("clientesNuevos", inquilinos.size());
        response.put("alquileresNuevos", alquileresFiltrados.size());

        return ResponseEntity.ok(response);
    }
}
