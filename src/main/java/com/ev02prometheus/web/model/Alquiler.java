package com.ev02prometheus.web.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "alquileres")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //clave primaria (ahora tendrás getId/setId correctos)

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "meses")
    private int meses;

    @Column(name = "monto_mensual", precision = 12, scale = 2)
    private BigDecimal montoMensual;

    @Column(name = "personas")
    private int personas;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "contrato")
    private String contrato;

    @Column(name = "inquilino_id")
    private Long inquilinoId;

    @Column(name = "propiedad_id")
    private Long propiedadId;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // --- Constructores ---
    public Alquiler() {}

    public Alquiler(Long id, LocalDate fechaInicio, LocalDate fechaFin, int meses,
                    BigDecimal montoMensual, int personas, boolean activo,
                    String contrato, Long inquilinoId, Long propiedadId,
                    LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.meses = meses;
        this.montoMensual = montoMensual;
        this.personas = personas;
        this.activo = activo;
        this.contrato = contrato;
        this.inquilinoId = inquilinoId;
        this.propiedadId = propiedadId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // --- Getters y Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public int getMeses() { return meses; }
    public void setMeses(int meses) { this.meses = meses; }

    public BigDecimal getMontoMensual() { return montoMensual; }
    public void setMontoMensual(BigDecimal montoMensual) { this.montoMensual = montoMensual; }

    public int getPersonas() { return personas; }
    public void setPersonas(int personas) { this.personas = personas; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public String getContrato() { return contrato; }
    public void setContrato(String contrato) { this.contrato = contrato; }

    public Long getInquilinoId() { return inquilinoId; }
    public void setInquilinoId(Long inquilinoId) { this.inquilinoId = inquilinoId; }

    public Long getPropiedadId() { return propiedadId; }
    public void setPropiedadId(Long propiedadId) { this.propiedadId = propiedadId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}