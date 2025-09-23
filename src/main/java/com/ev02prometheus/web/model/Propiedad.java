package com.ev02prometheus.web.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad que representa una Propiedad en el sistema.
 * Puede ser una casa, apartamento, etc.
 */
@Entity
@Table(name = "propiedades")
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental en BD
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private boolean rentado;  // Indica si está rentado actualmente

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructor vacío (obligatorio para JPA)
    public Propiedad() {}

    // Constructor completo
    public Propiedad(Long id, String nombre, String direccion, String descripcion,
                     boolean rentado, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.rentado = rentado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isRentado() { return rentado; }
    public void setRentado(boolean rentado) { this.rentado = rentado; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    /**
     * Callback antes de insertar el registro.
     */
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Callback antes de actualizar el registro.
     */
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}