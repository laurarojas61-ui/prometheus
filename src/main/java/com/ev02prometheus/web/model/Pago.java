package com.ev02prometheus.web.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entidad Pago
 * Representa los pagos realizados por un inquilino sobre un alquiler.
 * Compatible con JPA (Hibernate) y JDBC.
 */
@Entity
@Table(name = "pagos")
public class Pago {

    // Identificador único del pago
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con el alquiler (solo guardamos el ID como referencia simple)
    @Column(name = "alquiler_id", nullable = false)
    private Long alquilerId;

    // Fecha en la que se realiza el pago
    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    // Monto del pago mensual
    @Column(name = "monto_mensual", precision = 10, scale = 2, nullable = false)
    private BigDecimal montoMensual;

    // Indica si el alquiler fue pagado o no
    @Column(name = "alquiler_pago", nullable = false)
    private boolean alquilerPago;

    // Comprobante del pago de alquiler (puede ser un código o ruta a archivo)
    @Column(name = "comp_alquiler", length = 255)
    private String compAlquiler;

    // Recibos y comprobantes de servicios públicos
    @Column(name = "recibo_agua", length = 255)
    private String reciboAgua;

    @Column(name = "comp_agua", length = 255)
    private String compAgua;

    @Column(name = "recibo_energia", length = 255)
    private String reciboEnergia;

    @Column(name = "comp_energia", length = 255)
    private String compEnergia;

    @Column(name = "recibo_gas", length = 255)
    private String reciboGas;

    @Column(name = "comp_gas", length = 255)
    private String compGas;

    // Auditoría: fechas de creación y última actualización
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Constructores
    public Pago() {}

    public Pago(Long id, Long alquilerId, LocalDate fechaPago, BigDecimal montoMensual,
                boolean alquilerPago, String compAlquiler,
                String reciboAgua, String compAgua,
                String reciboEnergia, String compEnergia,
                String reciboGas, String compGas,
                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.alquilerId = alquilerId;
        this.fechaPago = fechaPago;
        this.montoMensual = montoMensual;
        this.alquilerPago = alquilerPago;
        this.compAlquiler = compAlquiler;
        this.reciboAgua = reciboAgua;
        this.compAgua = compAgua;
        this.reciboEnergia = reciboEnergia;
        this.compEnergia = compEnergia;
        this.reciboGas = reciboGas;
        this.compGas = compGas;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAlquilerId() { return alquilerId; }
    public void setAlquilerId(Long alquilerId) { this.alquilerId = alquilerId; }

    public LocalDate getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }

    public BigDecimal getMontoMensual() { return montoMensual; }
    public void setMontoMensual(BigDecimal montoMensual) { this.montoMensual = montoMensual; }

    public boolean isAlquilerPago() { return alquilerPago; }
    public void setAlquilerPago(boolean alquilerPago) { this.alquilerPago = alquilerPago; }

    public String getCompAlquiler() { return compAlquiler; }
    public void setCompAlquiler(String compAlquiler) { this.compAlquiler = compAlquiler; }

    public String getReciboAgua() { return reciboAgua; }
    public void setReciboAgua(String reciboAgua) { this.reciboAgua = reciboAgua; }

    public String getCompAgua() { return compAgua; }
    public void setCompAgua(String compAgua) { this.compAgua = compAgua; }

    public String getReciboEnergia() { return reciboEnergia; }
    public void setReciboEnergia(String reciboEnergia) { this.reciboEnergia = reciboEnergia; }

    public String getCompEnergia() { return compEnergia; }
    public void setCompEnergia(String compEnergia) { this.compEnergia = compEnergia; }

    public String getReciboGas() { return reciboGas; }
    public void setReciboGas(String reciboGas) { this.reciboGas = reciboGas; }

    public String getCompGas() { return compGas; }
    public void setCompGas(String compGas) { this.compGas = compGas; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    /**
     * Métodos de ciclo de vida JPA para auditar automáticamente
     */
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}